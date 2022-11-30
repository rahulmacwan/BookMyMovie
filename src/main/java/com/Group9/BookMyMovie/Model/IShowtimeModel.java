package com.Group9.BookMyMovie.Model;

import java.util.List;

public interface IShowtimeModel {

    public List<ShowtimeModel> getShowtime(Integer movieid, Integer theaterid);

}
