package com.Group9.BookMyMovie.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Group9.BookMyMovie.Configuration.BookMyMoviePersistenceFactory;

public class RewardsModel implements IRewardModel {
	
    private static final Logger logger = LoggerFactory.getLogger(RewardsModel.class);


    @Override
    public BookingModel claimReward(BookingModel bookingModel) {
      try {
        float amount = bookingModel.getAmount();
        float rewardAmount = BookMyMoviePersistenceFactory.getInstance().createRewardPersistence().getRewards(bookingModel.getUserId());
        if (amount > rewardAmount) {
            float finalAmount = amount - rewardAmount;
            BookMyMoviePersistenceFactory.getInstance().createRewardPersistence().updateRewards(0, bookingModel.getUserId());
            bookingModel.setAmount(finalAmount);
        } else if (rewardAmount >= amount) {
            float finalRewardAmount = rewardAmount - amount;
            float finalAmount = 0f;
            BookMyMoviePersistenceFactory.getInstance().createRewardPersistence().updateRewards(finalRewardAmount, bookingModel.getUserId());
            bookingModel.setAmount(finalAmount);
        }
    	}
    	catch (Exception e) {
			logger.debug(e.getMessage());
		}
        return bookingModel;
    }

    public float getRewards(String emailid) {
        Integer userId = BookMyMoviePersistenceFactory.getInstance().createUserPersistence().getUserIDFromEmail(emailid);
        float rewardsamount = BookMyMoviePersistenceFactory.getInstance().createRewardPersistence().getRewards(userId);
        return rewardsamount;
    }
}
