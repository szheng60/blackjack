package com.song.pointalgorithm;

import com.song.card.Countable;

public class AcePointAlg implements PointAlg {

    private Countable hand;

    public AcePointAlg(Countable newHand) {
        hand = newHand;
    }

    @Override
    public int calculatePoint() {
        final int asOne = calculatePointWithAceAsOne();
        final int asEleven = calculatePointWithAceAsEleven();
        return asOne > asEleven ? asOne : asEleven;
    }

    private int calculatePointWithAceAsOne() {
        int sum = 0;
        for (int i : hand.getCardsNumberOnHand()) {
            sum += i;
        }
        return sum;
    }

    private int calculatePointWithAceAsEleven() {
        int sum = 0;
        for (int i : hand.getCardsNumberOnHand()) {
            if (i == 1 && (sum + i) < 21) {
                i = 11;
            }
            sum += i;
        }
        return sum;
    }
}
