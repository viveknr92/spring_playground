package com.springinit.springInitDemo.repository;

import com.springinit.springInitDemo.model.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionJpaRepository extends JpaRepository<Session, Long>, SessionCustomJpaRepository {
    List<Session> findBySessionNameContains(String name);
    List<Session> findBySessionLengthNot(Integer sessionLength);
    List<Session> findBySessionNameNotLike(String name);
    List<Session> findBySessionLengthLessThan(Integer sessionLength);
    void deleteBySessionId(Long sessionId);

    @Query("SELECT s from Session s where s.sessionName like %:name")
    Page<Session> getSessionWithName(@Param("name") String name, Pageable pageable);
}
