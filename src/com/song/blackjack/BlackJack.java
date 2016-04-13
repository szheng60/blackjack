package com.song.blackjack;

import com.song.builder.GameSystem;
import com.song.builder.GameSystem.GameSystemBuilder;
import com.song.player.Dealer;
import com.song.player.Player;

public class BlackJack {

    public static void main(String[] args) {

        GameSystem gs = GameSystemBuilder.newBuilder().addDealer(new Dealer("Dealer")).addPlayer(new Player("Player"))
                .build();
        gs.start();
    }
}
