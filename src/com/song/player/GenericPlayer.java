package com.song.player;

import static com.song.player.ActionState.WAIT;

import com.song.card.Card;
import com.song.card.CardDispatchable;
import com.song.card.CardHand;

public abstract class GenericPlayer implements Playable, Displayable {

    private CardHand hand;
    private ActionState state;
    private String name;

    public GenericPlayer(String name) {
        hand = new CardHand();
        state = WAIT;
        this.name = name;
    }

    public void takeACard(CardDispatchable dispatchable) {
        takeACard(dispatchable.dispatch());
    }

    protected void takeACard(Card newCard) {
        hand.addCard(newCard);
    }

    public void setState(ActionState state) {
        this.state = state;
    }

    public ActionState getState() {
        return state;
    }

    public void stand() {
        setState(ActionState.STAND);
    }

    @Override
    public int getPoint() {
        return hand.getPoint();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String showHandCards() {
        return hand.toString();
    }

    public abstract String showFirstHandCards();

    @Override
    public String toString() {
        return getName() + " - " + showHandCards() + " - " + getPoint();
    }

    String getCardDetail(int index) {
        return hand.getCardDetail(index);
    }
}
