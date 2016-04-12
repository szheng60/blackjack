package com.song.card;

public enum CardSuit {
    BLADE, CLUB, HEART, DIAMOND;

    @Override
    public String toString() {
        return name();
    }
}
