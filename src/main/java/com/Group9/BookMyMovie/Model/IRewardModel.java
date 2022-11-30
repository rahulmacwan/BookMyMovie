package com.Group9.BookMyMovie.Model;

public interface IRewardModel {
	
    public BookingModel claimReward(BookingModel bookingModel);

    public float getRewards(String emailid);

}
