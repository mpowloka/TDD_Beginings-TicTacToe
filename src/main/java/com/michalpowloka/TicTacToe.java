package com.michalpowloka;

public class TicTacToe {
    private char actualPlayer = 'O';
    private Character[][] board = {
           {'\0', '\0', '\0'},
           {'\0', '\0', '\0'},
           {'\0', '\0', '\0'}
   };
    //TODO
    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        setMarker(x, y);

        String message = "No winner";
        actualPlayer = nextPlayer();

        if(board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') return "X won!";

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

}
