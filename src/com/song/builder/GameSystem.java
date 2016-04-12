package com.song.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.song.card.CardDeck;
import com.song.card.CardDispatchable;
import com.song.card.CardDispatcher;
import com.song.player.Dealer;
import com.song.player.GenericPlayer;
import com.song.player.Player;
import com.song.util.DisplayInformation;

public class GameSystem extends Observable {

    private static GameSystem instance;
    private List<GenericPlayer> players;
    private CardDispatchable cardDispatcher;
    private GenericPlayer dealer;

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

    public static class GameSystemBuilder implements GameBuilder, PlayerBuilder, CardBuilder, SystemBuilder {
        private GenericPlayer dealer;
        private List<GenericPlayer> players;
        private CardDeck cardDeck;
        private CardDispatchable cardDispatcher;

        private GameSystemBuilder() {
            players = new ArrayList<GenericPlayer>();
        }

        public static GameBuilder newBuilder() {
            return new GameSystemBuilder();
        }

        private void updatePlayers(GenericPlayer player) {
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
        public CardBuilder addPlayer(Player newPlayer) {
            updatePlayers(newPlayer);
            return this;
        }

        @Override
        public SystemBuilder addCardDeck(CardDeck newCardDeck) {
            cardDeck = newCardDeck;
            return this;
        }

        @Override
        public GameSystem build() {
            cardDispatcher = new CardDispatcher(cardDeck);
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
                for (GenericPlayer player : players) {
                    player.takeACard(cardDispatcher);
                    DisplayInformation.preGame(player);
                }
            }
        }

    }

    private void midGame() {
        for (GenericPlayer player : players) {
            player.takeTurn(cardDispatcher);
            DisplayInformation.midGame(player);
        }
    }

    private void afterGame() {
        final int dealerPoint = dealer.getPoint();
        players.remove(dealer);
        for (GenericPlayer player : players) {
            if (player.isBusted()) {
                System.out.println(player + ", busted - result: Lose");
            } else {
                if (dealer.isBusted() || (player.getPoint() > dealerPoint)) {
                    System.out.println(player + ", result: Win");
                } else {
                    System.out.println(player + ", result: Lose");
                }
            }
        }
    }
}
