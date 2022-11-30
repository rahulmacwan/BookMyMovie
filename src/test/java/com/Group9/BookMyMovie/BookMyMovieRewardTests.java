package com.Group9.BookMyMovie;

import com.Group9.BookMyMovie.Model.BookingModel;
import com.Group9.BookMyMovie.Model.IRewardModel;
import com.Group9.BookMyMovie.Model.RewardsModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookMyMovieRewardTests {
    @Mock
    RewardsModel rewardModel;
    IRewardModel rewards;

    public BookMyMovieRewardTests() {
    }

    @Before
    public void setUp() {

        rewards = mock(RewardsModel.class);
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void checkClaimRewardNull() {
        BookingModel bookingModel = null;

        assertNull(rewards.claimReward(bookingModel));
    }

    @Test
    public void checkClaimRewardAmtGrtThanReward() {
        BookingModel bookingModel = new BookingModel();
        bookingModel.setUserId(1004);
        bookingModel.setAmount(50);
        float amount = bookingModel.getAmount();
        float rewardAmount = 40;
        float finalAmount = amount - rewardAmount;
        bookingModel.setAmount(finalAmount);

        when(rewards.claimReward(bookingModel)).thenReturn(bookingModel);

        assertNotNull(rewards.claimReward(bookingModel));
        assertEquals(rewards.claimReward(bookingModel), bookingModel);
        Assert.assertEquals(rewards.claimReward(bookingModel).getAmount(), finalAmount, 0);
    }


    @Test
    public void checkClaimRewardAmtLessThanReward() {
        BookingModel bookingModel = new BookingModel();
        bookingModel.setUserId(1004);
        bookingModel.setAmount(20);
        float amount = bookingModel.getAmount();
        float rewardAmount = 40;
        float finalAmount = rewardAmount - amount;
        bookingModel.setAmount(finalAmount);

        when(rewards.claimReward(bookingModel)).thenReturn(bookingModel);

        assertNotNull(rewards.claimReward(bookingModel));
        assertEquals(rewards.claimReward(bookingModel), bookingModel);
        Assert.assertEquals(rewards.claimReward(bookingModel).getAmount(), finalAmount, 0);
    }

}
