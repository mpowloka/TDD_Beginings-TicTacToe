package com.michalpowloka;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TicTacToeTest {

    private TicTacToe game;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public final void before() {
        game = new TicTacToe();
    }

    @Test
    public void play_xTooSmall_throwRuntimeException() {
        exception.expect(RuntimeException.class);
        game.play(0, 1);
    }

    @Test
    public void play_xTooBig_throwRuntimeException() {
        exception.expect(RuntimeException.class);
        game.play(4, 2);
    }

    @Test
    public void play_yTooSmall_throwRuntimeException() {
        exception.expect(RuntimeException.class);
        game.play(2,0);
    }

    @Test
    public void play_yTooBig_throwRuntimeException() {
        exception.expect(RuntimeException.class);
        game.play(4,0);
    }

    @Test
    public void play_placeOccupied_throwRuntimeException() {
        game.play(2,2);
        exception.expect(RuntimeException.class);
        game.play(2,2);
    }

    @Test
    public void play_gameStarted_noWinner() {
        String result = game.play(1,1);
        assertEquals("No winner", result);
    }

    @Test
    public void play_xPopulatedHorizontal_xWon() {
        game.play(1,1); //X
        game.play(2,2); //O
        game.play(2,1); //X
        game.play(3,3); //O
        String message = game.play(3, 1); //X

        System.out.println(game.boardStatus());

        assertEquals("X won!", message);
    }


    @Test
    public void nextPlayer_firstMove_X() {
        game.play(1,1);
        assertEquals('X', game.nextPlayer());
    }

    @Test
    public void nextPlayer_afterXTurn_O() {
        assertEquals('O', game.nextPlayer());
    }
}
