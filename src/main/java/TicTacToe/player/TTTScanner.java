package TicTacToe.player;

import TicTacToe.model.BoardModel;
import TicTacToe.model.TTTPositions;

import java.util.Scanner;

public class TTTScanner implements TTTPlayer {

    Scanner s = new Scanner(System.in);
    @Override
    public TTTPositions getMarkPositions(BoardModel board) {
        System.out.println("Podaj pozycje od 1 do 9");
          int input =  s.nextInt();
         // return getPositionWithSwitch(input);

        return getPositionWithMagic(input);
    }



    /*
    private TTTPositions getPositionWithMagic(int input) { // od 1 do 9 podstawiajac pod te wzory mam konkretne wspolrz.
        int y = (input - 1)% TicTacToe.BOARD_SIZE;
        int x = (input - 1)/ TicTacToe.BOARD_SIZE;
        return new TTTPositions(x,y);
    }*/

    private TTTPositions getPositionWithSwitch(int input) {
    switch(input){
        case 1:
            return new TTTPositions(0,0);
        case 2:
            return new TTTPositions(0,1);
        case 3:
            return new TTTPositions(0,2);
        case 4:
            return new TTTPositions(1,0);
        case 5:
            return new TTTPositions(1,1);
        case 6:
            return new TTTPositions(1,2);
        case 7:
            return new TTTPositions(2,0);
        case 8:
            return new TTTPositions(2,1);
        case 9:
            return new TTTPositions(2,2);
        default:
                return new TTTPositions(0,0);
    }

    }
}
