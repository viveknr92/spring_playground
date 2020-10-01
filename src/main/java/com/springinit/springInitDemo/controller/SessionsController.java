package com.springinit.springInitDemo.controller;

import com.springinit.springInitDemo.model.Session;
import com.springinit.springInitDemo.repository.SessionJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionJpaRepository sessionJpaRepository;

    @GetMapping
    public List<Session> list() {
        System.out.println("find all");
        return sessionJpaRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return sessionJpaRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody final Session session) {
       return sessionJpaRepository.saveAndFlush(session);
    }

//    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable Long id) {
//        // handle cascades
//        sessionJpaRepository.deleteById(id);
//    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        Session existingSession = sessionJpaRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionJpaRepository.saveAndFlush(existingSession);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        sessionJpaRepository.deleteBySessionId(id);
    }
}
