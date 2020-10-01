package com.springinit.springInitDemo.repository;

import com.springinit.springInitDemo.model.TicketType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TicketTypeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public TicketType find(String id) {
        return entityManager.find(TicketType.class, id);
    }
}