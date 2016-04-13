package com.song.util;

import com.song.player.Displayable;

public class DisplayInformation {

    public static void preGame(Displayable player) {
        display(player.showFirstHandCards(), player.getName());
    }

    public static void midGame(Displayable player) {
        String cardInfo = player.showHandCards() + " - " + player.getPoint();
        display(cardInfo, player.getName());
    }

    private static void display(String cardInfo, String name) {
        System.out.println(name + " - " + cardInfo);
    }

    public static void afterGame(Displayable player, final int dealerPoint) {
        String cardInfo = player.showHandCards() + " - " + player.getPoint();
        String result = "";
        if (player.getPoint() > 21) {
            result = " busted - result: Lose";
        } else {
            if (dealerPoint > 21 || (player.getPoint() > dealerPoint)) {
                result = " result: Win";
            } else {
                result = " result: Lose";
            }
        }
        display(cardInfo + result, player.getName());
    }
}
