package com.microservices.kubed.creditcard.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.microservices.kubed.creditcard.entity.CardEntity;
import com.microservices.kubed.creditcard.model.ConfigProperties;
import com.microservices.kubed.creditcard.model.Customer;
import com.microservices.kubed.creditcard.properties.CardServiceConfigProps;
import com.microservices.kubed.creditcard.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardsRestController {

    private final CardsRepository cardsRepository;
    private final CardServiceConfigProps configProps;

    @PostMapping("/cards")
    public ResponseEntity<List<CardEntity>> getCardDetails(@RequestBody Customer customer) {

        List<CardEntity> cards = cardsRepository.findByCustomerId(customer.getCustomerId());

        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping("/cards/properties")
    public ResponseEntity<String> getPropertyDetails() throws JsonProcessingException {

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ConfigProperties configProperties = new ConfigProperties(configProps.getMsg(), configProps.getBuildVersion(),
                configProps.getMailDetails(), configProps.getActiveBranches());

        String jsonString = objectWriter.writeValueAsString(configProperties);

        return new ResponseEntity<>(jsonString, HttpStatus.OK);
    }
}
