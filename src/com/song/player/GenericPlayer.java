package com.song.player;

import static com.song.player.ActionState.WAIT;

import com.song.card.Card;
import com.song.card.CardDispatchable;
import com.song.card.CardHand;
import com.song.pointalgorithm.PointAlgFactory;

public abstract class GenericPlayer implements PlayerAction, Displayable {

    private CardHand hand;
    private int point = 0;
    private ActionState state;
    private String name;
    private boolean isBusted = false;

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
        updatePoint();
    }

    public void setState(ActionState state) {
        this.state = state;
    }

    public ActionState getState() {
        return state;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    private void updatePoint() {
        final int point = PointAlgFactory.getFactory(hand).calculate();
        setPoint(point);
    }

    public void setBusted(boolean isBusted) {
        this.isBusted = isBusted;
    }

    public boolean isBusted() {
        return isBusted;
    }

    @Override
    public void stand() {
        setState(ActionState.STAND);
    }

    @Override
    public int getPoint() {
        return point;
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
