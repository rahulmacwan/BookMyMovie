package com.Group9.BookMyMovie.Configuration;


import com.Group9.BookMyMovie.Validation.IUserValidation;
import com.Group9.BookMyMovie.Validation.IValidatePayment;
import com.Group9.BookMyMovie.Validation.UserValidation;
import com.Group9.BookMyMovie.Validation.ValidateCVV;
import com.Group9.BookMyMovie.Validation.ValidateExpiryMonth;
import com.Group9.BookMyMovie.Validation.ValidateExpiryYear;
import com.Group9.BookMyMovie.Validation.ValidateCreditCard;
import com.Group9.BookMyMovie.repo.*;

public class BookMyMoviePersistenceFactory implements IBookMyMoviePersistenceFactory {

    private static BookMyMoviePersistenceFactory bookMyMoviePersistenceFactory = null;

    private BookMyMoviePersistenceFactory() {

    }

    public static BookMyMoviePersistenceFactory getInstance() {
        if (bookMyMoviePersistenceFactory == null)
            bookMyMoviePersistenceFactory = new BookMyMoviePersistenceFactory();

        return bookMyMoviePersistenceFactory;
    }

    @Override
    public IBookingPersistence createBookingPersistence() {
        return new BookingPersistence();
    }

    @Override
    public IUserPersistence createUserPersistence() {
        return new UserPersistence();
    }

    @Override
    public ISeatSelectionPersistence createISeatSelectionPersistence() {
        return new SeatSelectionPersistence();
    }

    @Override
    public ILocationPersistence createLocationPersistence() {
        return new LocationPersistence();
    }

    @Override
    public IMoviePersistence createmoviePersistence() {
        return new MoviePersistence();
    }



    @Override
    public IPaymentPersistence createPaymentPersistence() {
        return new PaymentPersistence();
    }

    @Override
    public IRewardPersistence createRewardPersistence() {
        return new RewardsPersistence();
    }

    @Override
    public ITheaterPersistence createtheaterPersistence() {
        return new TheaterPersistence();
    }

    @Override
    public ITicketGenerationPersistence createticketGenerationPersistence() {
        return new TicketGenerationPersistence();
    }

    @Override
    public IUserValidation createuserValidation() {
        return new UserValidation();
    }

    @Override
    public IShowtimePersistence createShowTimePersistence() {
        return new ShowtimePersistence();
    }

	@Override
	public IValidatePayment createCreditCardValidation() {
	
		return new ValidateCreditCard();
	}

	@Override
	public IValidatePayment createCVVValidation() {
		
		return new ValidateCVV() ;
	}

	@Override
	public IValidatePayment createExpiryYearValidation() {
	
		return new ValidateExpiryYear();
	}

	@Override
	public IValidatePayment createExpiryMonthValidation() {
	
		return new ValidateExpiryMonth();
	}

}
