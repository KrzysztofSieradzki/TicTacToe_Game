package TicTacToe;

import TicTacToe.model.BoardModel;
import TicTacToe.model.FieldState;
import TicTacToe.model.TTTResult;
import TicTacToe.view.TicTacToeView;



public class TicTacToe implements BoardModel {

    private boolean isPlayerXTurn = true;

    private FieldState [][] board;
    public final static int BOARD_SIZE = 3;
    private TicTacToeView view;

    public TicTacToe(TicTacToeView view) {
        this.view=view;
        board = new FieldState[BOARD_SIZE][BOARD_SIZE];
        initBoard();
    }

    public boolean isPlayerXTurn() {
        return isPlayerXTurn;
    }

    private void initBoard() {
        for (int i = 0; i <BOARD_SIZE ; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) { board[i][j]=FieldState.EMPTY; } }
    }



    @Override
    public FieldState getFieldStatus(int x, int y) { return board[x][y]; }

    public void putMark(int x, int y) {
        if(getFieldStatus(x,y)!= FieldState.EMPTY){ throw new FieldTakenException(x,y); }
        if( x<0 || x>=BOARD_SIZE || y<0 || y>=BOARD_SIZE){ throw new ArrayIndexOutOfBoundsException();}


    if ( isPlayerXTurn) { board[x][y]= FieldState.X; }
    else { board[x][y]= FieldState.O; }

        isPlayerXTurn = !isPlayerXTurn;
    }


    public void refreshView() {
        view.printBox(this);
    }

    public TTTResult checkResult() {

        if(isPlayerOWin()==true){ return TTTResult.PLAYER_O_WIN; }
        if(isPlayerXWin()==true){ return TTTResult.PLAYER_X_WIN; }
        if(isPlayerOWin()==false && isPlayerXWin()==false&& isEmptyFile()==false){ return TTTResult.DRAW;}
        if(isPlayerOWin()==false && isPlayerXWin()==false && isEmptyFile()==true){
            return TTTResult.GAME_IN_PROGRESS;
        }

        return null;
    }

    private boolean isEmptyFile() {
        int counterEmptyField=0;
        for (int i = 0; i <BOARD_SIZE; i++) {
            for (int j = 0; j <BOARD_SIZE ; j++) {
                if(getFieldStatus(i,j)==FieldState.EMPTY){counterEmptyField++; }
            }
        }
        if(counterEmptyField==0)
            return false;
        else
            return true;
    }

    private boolean isWin(FieldState state) {
        for (int i = 0; i <BOARD_SIZE ; i++) {

            int horizontalChecker=0;
            int verticalChecker =0;
            int naSkosChecker = 0;
            int naDrugiSkosChecker=0;

            for (int j = 0; j <BOARD_SIZE ; j++) {
                if(board[i][j]==state) horizontalChecker++;
                if(board[j][i]==state) verticalChecker++;
                if(board[j][j]==state  ) naSkosChecker++;
                if(board[j][2-j]==state)naDrugiSkosChecker++;
            }
            if(horizontalChecker==3) return true;
            if(verticalChecker==3) return true;
            if(naSkosChecker==3) return true;
            if(naDrugiSkosChecker==3) return true;
        }
        return false;
    }

    private boolean isPlayerXWin() {
        FieldState state = FieldState.X;
        return isWin(state);
    }

    private boolean isPlayerOWin() {

        FieldState state = FieldState.O;
        return isWin(state);
    }



}
