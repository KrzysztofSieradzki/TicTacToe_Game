package TicTacToe.player;

import TicTacToe.TicTacToe;
import TicTacToe.model.BoardModel;
import TicTacToe.model.TTTPositions;

public interface TTTPlayer {

    TTTPositions getMarkPositions(BoardModel board);

    /**
     * Get position board on parametr
     * @param input number from console ( 1 - 9 )
     * @return position based on x and y
     */


    default TTTPositions getPositionWithMagic(int input) { // od 1 do 9 podstawiajac pod te wzory mam konkretne wspolrz.
        int y = (input - 1)% TicTacToe.BOARD_SIZE;
        int x = (input - 1)/ TicTacToe.BOARD_SIZE;
        return new TTTPositions(x,y);
    }
}
