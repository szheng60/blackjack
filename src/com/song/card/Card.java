package com.song.card;

public class Card {
    private CardNumbers number;
    private CardSuit suit;

    public Card() {

    }

    public Card(Card copy) {
        number = copy.number;
        suit = copy.suit;
    }

    public Card(CardNumbers number, CardSuit suit) {
        this.number = number;
        this.suit = suit;
    }

    public final int getCardNumber() {
        return number.getNumber();
    }

    public boolean isAce() {
        return number == CardNumbers.ACE;
    }

    @Override
    public String toString() {
        return suit.toString() + "-" + number.toString();
    }
}
