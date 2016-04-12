package com.song.pointalgorithm;

import com.song.card.Countable;

public class AceAlgFactory extends PointAlgFactory {

    public AceAlgFactory(Countable hand) {
        setAlgorithm(new AcePointAlg(hand));
    }

}
