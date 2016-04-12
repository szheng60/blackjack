package com.song.util;

import com.song.player.Displayable;

public class DisplayInformation {

    public static void preGame(Displayable info) {
        display(info.showFirstHandCards(), info.getName());
    }

    public static void midGame(Displayable info) {
        String cardInfo = info.showHandCards() + " - " + info.getPoint();
        display(cardInfo, info.getName());
    }

    private static void display(String cardInfo, String name) {
        System.out.println(name + " - " + cardInfo);
    }
}
