package com.song.player;

import com.song.card.Card;
import com.song.card.CardDispatchable;

public interface PlayerAction {

    void takeTurn(CardDispatchable dispatcher);

    void hit(Card newCard);

    void stand();
}
