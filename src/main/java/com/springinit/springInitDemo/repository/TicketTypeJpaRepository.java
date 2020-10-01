package com.springinit.springInitDemo.repository;

import com.springinit.springInitDemo.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketTypeJpaRepository extends JpaRepository<TicketType, String> {
    List<TicketType> findByIncludesWorkshopTrue();
}
