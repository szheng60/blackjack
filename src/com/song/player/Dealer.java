package com.song.player;

import com.song.card.Card;
import com.song.card.CardDispatchable;

public class Dealer extends GenericPlayer {

    public Dealer(String name) {
        super(name);
    }

    @Override
    public void hit(Card newCard) {
        takeACard(newCard);
        if (getPoint() >= 17 && getPoint() <= 21) {
            stand();
        }
        if (getPoint() > 21) {
            setState(ActionState.DONE);
            setBusted(true);
        }
    }

    @Override
    public void takeTurn(CardDispatchable dispatcher) {
        setState(ActionState.HIT);
        if (getPoint() >= 17) {
            stand();
        }
        while (getState() == ActionState.HIT) {
            final Card newCard = dispatcher.dispatch();
            hit(newCard);
        }
    }

    @Override
    public String showFirstHandCards() {
        String msg = getCardDetail(0);
        if (getPoint() == 21) {
            msg = toString();
        }
        return msg;
    }
}
