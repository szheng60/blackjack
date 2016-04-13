package com.song.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.song.util.Randomizer;

public class CardDeck implements CardDispatchable {
    private List<Card> deck;
    private int numberOfCards;

    private CardDeck() {
        deck = new ArrayList<Card>();
    }

    public static CardDeck getInstance() {
        CardDeck deck = new CardDeck();
        deck.initialCardDeck();
        return deck;
    }

    private void initialCardDeck() {
        for (CardSuit type : CardSuit.values()) {
            for (CardNumbers number : CardNumbers.values()) {
                deck.add(new Card(number, type));
                updateNumberOfCards();
            }
        }
        shuffleTheDeck();
    }

    private void shuffleTheDeck() {
        Collections.shuffle(deck);
    }

    private void updateNumberOfCards() {
        numberOfCards = deck.size();
    }

    private Card removeCard(int index) {
        final Card theCard = deck.remove(index);
        updateNumberOfCards();
        return theCard;
    }

    public Card getRandomCard() {
        final int cardIndex = Randomizer.getRandom(numberOfCards);
        return removeCard(cardIndex);
    }

    public boolean isDeckEmpty() {
        return numberOfCards == 0;
    }

    public int numberOfCardsInDeck() {
        return numberOfCards;
    }

    @Override
    public Card dispatch() {
        Card newCard = new Card();
        if (!isDeckEmpty()) {
            newCard = getRandomCard();
        }
        return newCard;
    }

    @Override
    public boolean hasEnoughCards(int minimumCardNumber) {
        return numberOfCardsInDeck() >= minimumCardNumber;
    }
}
