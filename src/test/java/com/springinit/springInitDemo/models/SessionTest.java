package com.springinit.springInitDemo.models;

import com.springinit.springInitDemo.model.Session;
import com.springinit.springInitDemo.repository.SessionJpaRepository;
import com.springinit.springInitDemo.repository.SessionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SessionTest {
    @Autowired
    private SessionRepository repository;
    @Autowired
    private SessionJpaRepository jpaRepository;
    @Test
    public void test() throws Exception {
        List<Session> sessions = repository.getSessionsThatHaveName("Java");
        System.out.println("Session println" + sessions);
        assertTrue(sessions.size() > 0);
    }
    @Test
    public void testJpaNot() throws Exception {
        List<Session> sessions = jpaRepository.findBySessionLengthNot(30);
        assertTrue(sessions.size() > 0);
    }
    @Test
    public void testJpaNotLike() throws Exception {
        List<Session> sessions = jpaRepository.findBySessionNameNotLike("Java%");
        assertTrue(sessions.size() > 0);
    }
    @Test
    public void testJpaLessThan() throws Exception {
        List<Session> sessions = jpaRepository.findBySessionLengthLessThan(45);
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void testPagingSorting() throws Exception {
        Page<Session> sessions = jpaRepository.getSessionWithName("S", PageRequest.of(1,5, Sort.by(Sort.Direction.DESC, "sessionLength")));
        assertTrue(sessions.getTotalElements() > 0);
    }

    @Test
    public void testCustomImpl() throws Exception {
        List<Session> sessions = jpaRepository.customGetSessions();
        assertTrue(sessions.size() > 0);
    }
}