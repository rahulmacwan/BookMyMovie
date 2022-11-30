package com.Group9.BookMyMovie.repo;

import com.Group9.BookMyMovie.Entity.TicketGenerationEntity;

import java.util.List;

public interface ITicketGenerationPersistence {

    public List<TicketGenerationEntity> getTickets(Integer userid);
}
