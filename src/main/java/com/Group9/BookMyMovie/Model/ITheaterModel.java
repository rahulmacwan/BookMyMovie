package com.Group9.BookMyMovie.Model;

import java.util.List;

public interface ITheaterModel {

    public List<TheaterModel> getTheaterListByMovie(Integer movieId, Integer LocationId);

}
