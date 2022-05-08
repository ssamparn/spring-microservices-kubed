package com.microservices.kubed.creditcard.web.controller;

import com.microservices.kubed.creditcard.entity.CardEntity;
import com.microservices.kubed.creditcard.model.Customer;
import com.microservices.kubed.creditcard.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardsRestController {

    private final CardsRepository cardsRepository;

    @PostMapping("/cards")
    public ResponseEntity<List<CardEntity>> getCardDetails(@RequestBody Customer customer) {

        List<CardEntity> cards = cardsRepository.findByCustomerId(customer.getCustomerId());

        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
}
