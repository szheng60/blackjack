package com.song.card;

public class CardDispatcher implements CardDispatchable {

    private CardDeck cardDeck;

    public CardDispatcher(CardDeck newCardDeck) {
        cardDeck = newCardDeck;
    }

    @Override
    public Card dispatch() {
        Card newCard = new Card();
        if (!cardDeck.isDeckEmpty()) {
            newCard = cardDeck.getRandomCard();
        }
        return newCard;
    }

    @Override
    public boolean hasEnoughCards(int minimumCardNumber) {
        return cardDeck.numberOfCardsInDeck() >= minimumCardNumber;
    }
}
