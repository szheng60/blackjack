package com.song.pointalgorithm;

import com.song.card.Countable;

public class RegularAlgFactory extends PointAlgFactory {

    RegularAlgFactory(Countable hand) {
        setAlgorithm(new RegularPointAlg(hand));
    }
}
