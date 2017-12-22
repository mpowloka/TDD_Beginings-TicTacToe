package com.michalpowloka;

public class TicTacToe {

    private static final int SIZE = 3;
    private char actualPlayer = 'X';
    private Character[][] board = {
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'}
    };

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        setMarker(x, y);

        String message = "No winner";
        if(gameIsOver()) message =  actualPlayer + " won!";
        actualPlayer = nextPlayer();

        return message;
    }

    public char nextPlayer() {
        return actualPlayer == 'X' ? 'O' : 'X';
    }

    private void checkAxis(int index) {
        if(index < 1 || index > 3) throw new RuntimeException("X outside of board");
    }

    private void setMarker(int x, int y) {
        if (board[x-1][y-1] != '\0') throw new RuntimeException("Place is already occupied");
        board[x-1][y-1] = actualPlayer;
    }

    private boolean gameIsOver() {

        for(int i = 0; i< SIZE; i++) {
            if(board[0][i] + board[1][i] + board[2][i] == actualPlayer * SIZE)
                return true;
        }

        return  false;
    }

    public String boardStatus() {
        String status = board[0][0] + " : " + board[1][0] + " : " + board[2][0] + "\n";
        status += board[0][1] + " : " + board[1][1] + " : " + board[2][1] + "\n";
        status += board[0][2] + " : " + board[1][2] + " : " + board[2][2] + "\n";

        return status;
    }

}
