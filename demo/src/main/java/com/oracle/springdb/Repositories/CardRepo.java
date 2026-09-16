package com.oracle.springdb.Repositories;

import com.oracle.springdb.Model.Card;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepo extends JpaRepository<Card, UUID> {
}
