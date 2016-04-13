package com.song.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.song.pointalgorithm.PointAlgFactory;

public class CardHand implements Countable {

    private List<Card> hand;
    private boolean holdingAce = false;
    private int point;

    public CardHand() {
        hand = new ArrayList<Card>();
    }

    public CardHand(CardHand copy) {
        hand = copy.hand;
        holdingAce = copy.holdingAce;
    }

    public void addCard(Card newCard) {
        if (newCard.isAce()) {
            holdingAce = true;
        }
        updateHand(newCard);
        updatePoint();
    }

    private void updatePoint() {
        final int point = PointAlgFactory.getFactory(this).calculate();
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public String getCardDetail(int index) {
        Card card = new Card();
        if (hand.size() > 0) {
            card = new Card(hand.get(index));
        }
        return card + " - " + card.getCardNumber();
    }

    private void updateHand(Card newCard) {
        hand.add(newCard);
    }

    public boolean containsAce() {
        return holdingAce;
    }

    @Override
    public List<Integer> getCardsNumberOnHand() {
        List<Integer> numbers = new ArrayList<Integer>();
        for (Card card : hand) {
            numbers.add(card.getCardNumber());
        }
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return "hand: " + hand.toString();
    }
}
