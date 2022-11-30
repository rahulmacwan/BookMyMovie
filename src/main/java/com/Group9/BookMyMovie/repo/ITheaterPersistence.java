package com.Group9.BookMyMovie.repo;

import com.Group9.BookMyMovie.Entity.TheaterEntity;

import java.util.List;

public interface ITheaterPersistence {

    public List<TheaterEntity> getTheaterListByMovie(Integer movieId, Integer LocationId);
}
