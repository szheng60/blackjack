package com.song.card;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.song.player.ActionState;
import com.song.util.PlayerInput;

public class PlayerInputTest {

    @Test
    public void test_hit() {
        ActionState as = PlayerInput.getPlayerChoice();
        assertTrue(as == ActionState.HIT);
    }

    @Test
    public void test_stand() {
        ActionState as = PlayerInput.getPlayerChoice();
        assertTrue(as == ActionState.STAND);
    }
}
