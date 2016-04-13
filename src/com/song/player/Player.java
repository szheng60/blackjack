package com.song.player;

import com.song.card.Card;
import com.song.card.CardDispatchable;
import com.song.util.PlayerInput;

public class Player extends GenericPlayer {

    public Player(String name) {
        super(name);
    }

    @Override
    public void hit(Card newCard) {
        takeACard(newCard);
        if (getPoint() > 21) {
            setState(ActionState.DONE);
        }
    }

    @Override
    public void takeTurn(CardDispatchable dispatcher) {
        setState(PlayerInput.getPlayerChoice());
        if (getState() == ActionState.STAND) {
            stand();
        }
        while (getState() == ActionState.HIT) {
            final Card newCard = dispatcher.dispatch();
            hit(newCard);
            if (getState() != ActionState.DONE) {
                System.out.println(this);
                setState(PlayerInput.getPlayerChoice());
            }
        }

    }

    @Override
    public String showFirstHandCards() {
        return showHandCards() + " - " + getPoint();
    }

}
