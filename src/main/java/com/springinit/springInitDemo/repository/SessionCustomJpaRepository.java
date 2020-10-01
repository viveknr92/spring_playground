package com.springinit.springInitDemo.repository;

import com.springinit.springInitDemo.model.Session;

import java.util.List;

public interface SessionCustomJpaRepository {
    List<Session> customGetSessions();
}
