package com.Group9.BookMyMovie.Model;

import java.util.List;

public interface ISeatSelectionModel {

    List<SeatSelectionModel> getSeatsByShowDetails(Integer theaterId, Integer movieId, Integer showId);
}
