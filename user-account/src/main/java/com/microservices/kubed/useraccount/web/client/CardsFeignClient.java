package com.microservices.kubed.useraccount.web.client;

import com.microservices.kubed.useraccount.model.Card;
import com.microservices.kubed.useraccount.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("cards")
public interface CardsFeignClient {
    @PostMapping(value = "cards", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Card> getCardDetails(@RequestBody Customer customer);
}
