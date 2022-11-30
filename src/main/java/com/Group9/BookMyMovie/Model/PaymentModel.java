package com.Group9.BookMyMovie.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Group9.BookMyMovie.Configuration.BookMyMoviePersistenceFactory;

public class PaymentModel implements IPaymentModel {

    private long creditcard;
    private Integer cvv;
    private Integer expiryYear;
    private Integer expiryMonth;
    private float amount;

    public long getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(long creditcard) {
        this.creditcard = creditcard;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Integer getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(Integer expiryYear) {
        this.expiryYear = expiryYear;
    }

    public Integer getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(Integer expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentModel [creditcard=" + creditcard + ", cvv=" + cvv + ", expiryYear=" + expiryYear
                + ", expiryMonth=" + expiryMonth + ", amount=" + amount + "]";
    }
    
    private static final Logger logger = LoggerFactory.getLogger(PaymentModel.class);


    public PaymentResponse payment(PaymentModel paymentModel, String emailid) {
        PaymentResponse response = new PaymentResponse();
        try {
        boolean validateCVV = BookMyMoviePersistenceFactory.getInstance().createCVVValidation().validate(String.valueOf(paymentModel.getCvv()));
        boolean validateCreditCard = BookMyMoviePersistenceFactory.getInstance().createCreditCardValidation().validate(String.valueOf(paymentModel.getCreditcard()));
        boolean validateExpiryYear = BookMyMoviePersistenceFactory.getInstance().createExpiryYearValidation().validate(String.valueOf(paymentModel.getExpiryYear()));
        boolean validateExpiryMonth = BookMyMoviePersistenceFactory.getInstance().createExpiryMonthValidation().validate(String.valueOf(paymentModel.getExpiryMonth()));
        int rewardDeductionPercent = 10;
        Integer userId = BookMyMoviePersistenceFactory.getInstance().createUserPersistence().getUserIDFromEmail(emailid);
        
        if (validateCreditCard) {
            if (validateCVV) {
                if (validateExpiryYear && validateExpiryMonth) {
                    float rewards = BookMyMoviePersistenceFactory.getInstance().createRewardPersistence().getRewards(userId);
                    float rewardamount = paymentModel.getAmount() / rewardDeductionPercent;
                    float newRewards = rewards + rewardamount;
                    BookMyMoviePersistenceFactory.getInstance().createRewardPersistence().updateRewards(newRewards, userId);
                    BookMyMoviePersistenceFactory.getInstance().createPaymentPersistence().updatePayment(userId, paymentModel.getAmount());
                    response.setResponseStatus(true);
                    response.setResponseMessage("Payment Successfull!");

                } else {
                    response.setResponseStatus(false);
                    response.setResponseMessage("Invalid Expiry year or month!");
                }

            } else {
                response.setResponseStatus(false);
                response.setResponseMessage("Invalid CVV!");
            }

        } else {
            response.setResponseStatus(false);
            response.setResponseMessage("Invalid Credit Card!");
        }
        }
        catch(Exception e)
        {
        	logger.error(e.getMessage());
        }
        return response;

    }

}
