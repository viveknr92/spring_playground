package com.springinit.springInitDemo.repository;

import com.springinit.springInitDemo.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
    List<Speaker> findByFirstNameAndLastName(String firstName, String lastName);
    List<Speaker> findByFirstNameOrLastName(String firstName, String lastName);
}
