package com.microservices.kubed.creditcard.repository;

import com.microservices.kubed.creditcard.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardsRepository extends JpaRepository<CardEntity, Long> {
    List<CardEntity> findByCustomerId(int customerId);
}
