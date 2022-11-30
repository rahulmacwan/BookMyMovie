package com.Group9.BookMyMovie.repo;

import com.Group9.BookMyMovie.Entity.ShowtimeEntity;

import java.util.List;

public interface IShowtimePersistence {

    public List<ShowtimeEntity> getShowtime(Integer movieid, Integer theaterid);
}
