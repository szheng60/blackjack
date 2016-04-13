package com.song.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.song.card.CardDeck;
import com.song.card.CardDispatchable;
import com.song.player.Dealer;
import com.song.player.Playable;
import com.song.player.Player;
import com.song.util.DisplayInformation;

public class GameSystem extends Observable {

    private static GameSystem instance;
    private List<Playable> players;
    private CardDispatchable cardDispatcher;
    private Playable dealer;

    private GameSystem(GameSystemBuilder gsb) {
        players = gsb.players;
        cardDispatcher = gsb.cardDispatcher;
        dealer = gsb.dealer;
    }

    private static GameSystem getInstance(GameSystemBuilder gsb) {
        if (instance == null) {
            instance = new GameSystem(gsb);
        }
        return instance;
    }

    public static class GameSystemBuilder implements GameBuilder, PlayerBuilder, SystemBuilder {
        private Playable dealer;
        private List<Playable> players;
        private CardDispatchable cardDispatcher;

        private GameSystemBuilder() {
            cardDispatcher = CardDeck.getInstance();
            players = new ArrayList<Playable>();
        }

        public static GameBuilder newBuilder() {
            return new GameSystemBuilder();
        }

        private void updatePlayers(Playable player) {
            players.add(0, player);
        }

        @Override
        public PlayerBuilder addDealer(Dealer newDealer) {
            if (dealer == null) {
                dealer = newDealer;
                updatePlayers(dealer);
            }
            return this;
        }

        @Override
        public SystemBuilder addPlayer(Player newPlayer) {
            updatePlayers(newPlayer);
            return this;
        }

        @Override
        public GameSystem build() {
            return getInstance(this);
        }
    }

    public void start() {
        preGame();
        midGame();
        afterGame();
    }

    private void preGame() {
        final int minumumCardsNeed = players.size() * 2;
        if (cardDispatcher.hasEnoughCards(minumumCardsNeed)) {
            for (int i = 0; i < 2; i++) {
                for (Playable player : players) {
                    player.hit(cardDispatcher.dispatch());
                    DisplayInformation.preGame(player);
                }
            }
        }

    }

    private void midGame() {
        for (Playable player : players) {
            player.takeTurn(cardDispatcher);
            DisplayInformation.midGame(player);
        }
    }

    private void afterGame() {
        final int dealerPoint = dealer.getPoint();
        players.remove(dealer);
        for (Playable player : players) {
            DisplayInformation.afterGame(player, dealerPoint);
        }
    }
}
