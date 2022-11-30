package com.Group9.BookMyMovie.repo;

public interface IRewardPersistence {

    public float getRewards(Integer userId);

    public void updateRewards(float amount, Integer userId);

}
