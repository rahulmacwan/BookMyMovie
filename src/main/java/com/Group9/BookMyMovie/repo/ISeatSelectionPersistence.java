package com.Group9.BookMyMovie.repo;

import com.Group9.BookMyMovie.Entity.SeatSelectionEntity;

import java.util.List;

public interface ISeatSelectionPersistence {

    List<SeatSelectionEntity> getSeatsByShowDetails(Integer theaterId, Integer movieId, Integer showId);

    public void updateSeatStatus(SeatSelectionEntity entity);

}
