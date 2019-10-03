package TicTacToe.player;

import TicTacToe.model.BoardModel;
import TicTacToe.model.FieldState;
import TicTacToe.model.TTTPositions;

import java.util.Random;

public class TTTRandomPlayer implements TTTPlayer {

    private Random random = new Random();

    @Override
    public TTTPositions getMarkPositions(BoardModel board) {
        while(true){
        int value = random.nextInt(9) +1;
        TTTPositions position = getPositionWithMagic(value);
        FieldState fieldState = board.getFieldStatus(position.getX(),position.getY());
        if(fieldState == fieldState.EMPTY){
            return position;
        }}

    }
}
