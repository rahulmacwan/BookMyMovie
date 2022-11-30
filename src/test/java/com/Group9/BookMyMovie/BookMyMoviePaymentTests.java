package com.Group9.BookMyMovie;

import com.Group9.BookMyMovie.Model.IPaymentModel;
import com.Group9.BookMyMovie.Model.PaymentModel;
import com.Group9.BookMyMovie.Model.PaymentResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookMyMoviePaymentTests {
    @Mock
    PaymentModel paymentmodel;
    IPaymentModel payment;

    public BookMyMoviePaymentTests() {
    }

    @Before
    public void setUp() {

        payment = mock(PaymentModel.class);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void paymentNullCheck() {
        PaymentModel paymentModel = null;

        assertNull(paymentModel);
    }

    @Test
    public void validPayment() {
        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setCreditcard(1278687191);
        paymentModel.setCvv(897);
        paymentModel.setExpiryMonth(9);
        paymentModel.setExpiryYear(2026);
        paymentModel.setAmount(50);

        PaymentResponse response = new PaymentResponse();
        response.setResponseStatus(true);
        when(paymentmodel.payment(paymentModel, "tushar@world.ca")).thenReturn(response);

        assertNotNull(paymentModel);
        assertEquals(true, paymentmodel.payment(paymentModel, "tushar@world.ca").isResponseStatus());
    }

    @Test
    public void InvalidPayment() {
        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setCreditcard(1278687191);
        paymentModel.setCvv(88877);
        paymentModel.setExpiryMonth(19);
        paymentModel.setExpiryYear(226);
        paymentModel.setAmount(50);

        PaymentResponse response = new PaymentResponse();
        response.setResponseStatus(false);
        when(paymentmodel.payment(paymentModel, "tushar@world.ca")).thenReturn(response);

        assertNotNull(paymentModel);
        assertEquals(false, paymentmodel.payment(paymentModel, "tushar@world.ca").isResponseStatus());
    }

}
