package com.song.player;

import com.song.card.Card;
import com.song.card.CardDispatchable;

public interface Playable extends Displayable {

    void takeTurn(CardDispatchable dispatcher);

    void hit(Card newCard);

}
