package com.song.util;

import java.util.Scanner;

import com.song.player.ActionState;

public class PlayerInput {
    public static Scanner sc = new Scanner(System.in);

    public static ActionState getPlayerChoice() {
        System.out.print("Player - Stand of Hit? Enter S/H -> ");
        ActionState state = null;
        if (sc.hasNext()) {
            final String input = sc.nextLine();
            if ('h' == Character.toLowerCase(input.charAt(0))) {
                state = ActionState.HIT;
            } else if ('s' == Character.toLowerCase(input.charAt(0))) {
                state = ActionState.STAND;
            }
        }
        return state;
    }
}
