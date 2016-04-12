package com.song.card;

public interface CardDispatchable {

    public Card dispatch();

    boolean hasEnoughCards(int minimumCardNumber);
}
