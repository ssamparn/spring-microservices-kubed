package com.microservices.kubed.creditcard.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.microservices.kubed.creditcard.entity.CardEntity;
import com.microservices.kubed.creditcard.model.Card;
import com.microservices.kubed.creditcard.model.ConfigProperties;
import com.microservices.kubed.creditcard.model.Customer;
import com.microservices.kubed.creditcard.properties.CardServiceConfigProps;
import com.microservices.kubed.creditcard.repository.CardsRepository;
import com.microservices.kubed.creditcard.service.CardsServiceResponseFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CardsRestController {

    private final CardsRepository cardsRepository;
    private final CardServiceConfigProps configProps;
    private final CardsServiceResponseFactory responseFactory;

    @PostMapping("/cards")
    public ResponseEntity<List<Card>> getCardDetails(@RequestHeader("X-Request-Trace-Id") String xRequestTraceId, @RequestBody Customer customer) {

        log.info("getCardDetails is called");

        List<CardEntity> cardsEntity = cardsRepository.findByCustomerId(customer.getCustomerId());

        List<Card> card = responseFactory.createCardsResponse(cardsEntity);

        return new ResponseEntity<>(card, HttpStatus.OK);
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
