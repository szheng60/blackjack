package com.song.pointalgorithm;

import com.song.card.CardHand;

public abstract class PointAlgFactory {

    private PointAlg algorithm;

    public static PointAlgFactory getFactory(CardHand hand) {
        if (hand.containsAce()) {
            return new AceAlgFactory(hand);
        } else {
            return new RegularAlgFactory(hand);
        }
    }

    void setAlgorithm(PointAlg algorithm) {
        this.algorithm = algorithm;
    }

    public int calculate() {
        return algorithm.calculatePoint();
    }
}
