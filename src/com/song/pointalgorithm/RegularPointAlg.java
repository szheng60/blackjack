package com.song.pointalgorithm;

import com.song.card.Countable;

public class RegularPointAlg implements PointAlg {

    private Countable hand;

    public RegularPointAlg(Countable newHand) {
        hand = newHand;
    }

    @Override
    public int calculatePoint() {
        int sum = 0;
        for (int i : hand.getCardsNumberOnHand()) {
            sum += i;
        }
        return sum;
    }

}
