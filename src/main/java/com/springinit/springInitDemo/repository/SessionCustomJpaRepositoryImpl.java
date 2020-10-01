package com.springinit.springInitDemo.repository;

import com.springinit.springInitDemo.model.Session;
import org.hibernate.SharedSessionContract;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class SessionCustomJpaRepositoryImpl implements SessionCustomJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Session> customGetSessions() {
        return entityManager.createQuery("SELECT s from Session s").getResultList();
    }
}
