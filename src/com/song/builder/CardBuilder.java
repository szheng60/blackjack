package com.song.builder;

import com.song.card.CardDispatchable;

public interface CardBuilder {
    public SystemBuilder addCardDeck(CardDispatchable newCardDeck);
}
