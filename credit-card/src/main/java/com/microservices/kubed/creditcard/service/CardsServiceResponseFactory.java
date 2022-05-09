package com.microservices.kubed.creditcard.service;

import com.microservices.kubed.creditcard.entity.CardEntity;
import com.microservices.kubed.creditcard.model.Card;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardsServiceResponseFactory {

    public List<Card> createCardsResponse(List<CardEntity> cardsEntity) {
        return cardsEntity.stream()
                .map(cardEntity -> {
                    Card card = new Card();
                    card.setCardId(cardEntity.getCardId());
                    card.setCustomerId(cardEntity.getCustomerId());
                    card.setCardNumber(cardEntity.getCardNumber());
                    card.setCardType(cardEntity.getCardType());
                    card.setTotalLimit(cardEntity.getTotalLimit());
                    card.setAmountUsed(cardEntity.getAmountUsed());
                    card.setAvailableAmount(cardEntity.getAvailableAmount());
                    card.setCreateDt(cardEntity.getCreateDt());
                    return card;
                }).collect(Collectors.toList());
    }
}