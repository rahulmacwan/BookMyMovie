package com.Group9.BookMyMovie.Model;

public interface IPaymentModel {

    public PaymentResponse payment(PaymentModel paymentModel, String userId);
}
