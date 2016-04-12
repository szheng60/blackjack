package com.song.util;

public class Randomizer {

    public static int getRandom(int max) {
        return (int) Math.random() * (max - 1);
    }
}
