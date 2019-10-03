package TicTacToe.view;

import TicTacToe.model.BoardModel;
import TicTacToe.model.FieldState;

import static TicTacToe.TicTacToe.BOARD_SIZE;

public class ConsoleTTTView implements TicTacToeView {

    @Override
    public void printBox(BoardModel board) {
        for (int i = 0; i <BOARD_SIZE ; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                FieldState fieldState = board.getFieldStatus(i,j);
                System.out.print(fieldState.getSymbol());
                if(j==0||j==1)
                    System.out.print("|");
            }
            System.out.println();
            if(i==0||i==1){ System.out.println("-+-+-"); }
        }
    }


}
