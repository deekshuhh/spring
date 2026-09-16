package com.oracle.spring.repository;

import com.oracle.spring.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepo extends JpaRepository<Card, UUID> {
}
