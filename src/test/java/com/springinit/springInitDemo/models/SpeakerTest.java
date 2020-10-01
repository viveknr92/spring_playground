package com.springinit.springInitDemo.models;

import com.springinit.springInitDemo.repository.SpeakerRepository;
import com.springinit.springInitDemo.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SpeakerTest {
    @Autowired
    private SpeakerRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testFind() throws Exception {
        Speaker speaker = repository.getOne(1L);
        assertNotNull(speaker);
    }

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        Speaker s = new Speaker();
        s.setCompany("Pluralsight");
        s.setFirst_name("Dan");
        s.setLast_name("Bunker");
        s.setTitle("Author");
        s.setSpeaker_bio("Consulting and mentoring");
        s = repository.saveAndFlush(s);

        // clear the persistence context so we don't return the previously cached location object
        // this is a test only thing and normally doesn't need to be done in prod code
        entityManager.clear();

        Speaker otherSpeaker = repository.getOne(s.getSpeaker_id());
        assertEquals("Dan", otherSpeaker.getFirst_name());

        repository.deleteById(otherSpeaker.getSpeaker_id());
    }

    @Test
    public void testJpaAnd() throws Exception {
        List<Speaker> speakers = repository.findByFirstNameAndLastName("Justin", "Clark");
        assertTrue(speakers.size() > 0);
    }

    @Test
    public void testJpaOr() throws Exception {
        List<Speaker> speakers = repository.findByFirstNameOrLastName("Justin", "Clark");
        assertTrue(speakers.size() > 0);
    }

}
