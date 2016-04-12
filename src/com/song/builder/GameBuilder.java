package com.song.builder;

import com.song.player.Dealer;

public interface GameBuilder {

    public PlayerBuilder addDealer(Dealer newDealer);
}
