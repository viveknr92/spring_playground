package com.springinit.springInitDemo.repository;

import com.springinit.springInitDemo.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SessionRepository {

//    @Autowired
    private SessionJpaRepository jpaRepository;
//    @Autowired
    public SessionRepository(SessionJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;

    public Session create(Session session) {
        return jpaRepository.saveAndFlush(session);
    }

    public Session update(Session session) {
        return jpaRepository.saveAndFlush(session);
    }

    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }

    public Session find(Long id) {
        return jpaRepository.getOne(id);
    }

    public List<Session> list() {
        return jpaRepository.findAll();
    }

    public List<Session> getSessionsThatHaveName(String name) {
        List<Session> ses = entityManager
                .createQuery("select s from Session s where s.sessionName like :name")
                .setParameter("name", "%" + name + "%").getResultList();
        return ses;
//        return jpaRepository.findBySessionNameContains(name);
    }
}
