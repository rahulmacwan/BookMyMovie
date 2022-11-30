package com.Group9.BookMyMovie.Configuration;


import com.Group9.BookMyMovie.Validation.IUserValidation;
import com.Group9.BookMyMovie.Validation.IValidatePayment;
import com.Group9.BookMyMovie.repo.*;

public interface IBookMyMoviePersistenceFactory {

    public IBookingPersistence createBookingPersistence();

    public IUserPersistence createUserPersistence();

    public ISeatSelectionPersistence createISeatSelectionPersistence();

    public ILocationPersistence createLocationPersistence();

    public IMoviePersistence createmoviePersistence();

    public IValidatePayment createCreditCardValidation();
    
    public IValidatePayment createCVVValidation();
    
    public IValidatePayment createExpiryYearValidation();
    
    public IValidatePayment createExpiryMonthValidation();

    public IPaymentPersistence createPaymentPersistence();

    public IRewardPersistence createRewardPersistence();

    public ITheaterPersistence createtheaterPersistence();

    public ITicketGenerationPersistence createticketGenerationPersistence();

    public IUserValidation createuserValidation();

    public IShowtimePersistence createShowTimePersistence();

}

