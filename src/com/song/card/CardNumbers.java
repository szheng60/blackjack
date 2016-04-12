package com.song.card;

public enum CardNumbers {
    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(
            10);

    private final int number;

    private CardNumbers(int n) {
        number = n;
    }

    public final int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return name();
    }
}
