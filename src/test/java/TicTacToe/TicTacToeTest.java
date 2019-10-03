package TicTacToe;

import TicTacToe.model.FieldState;

import TicTacToe.model.TTTResult;
import TicTacToe.view.TicTacToeView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static TicTacToe.TicTacToe.BOARD_SIZE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TicTacToeTest {
    private TicTacToe game;
    private TicTacToeView view;

    @BeforeEach
    public void setUp(){
       view = mock(TicTacToeView.class); // jak juz jestem pewien ze testy dzialaja, moge podmienic sztuczna tablica
        //przez mockito , dzieki temu testy leca szybciej
        //view = new ConsoleTTTView();
        game=new TicTacToe(view);
    }


    @Test
    public void atBeginningFieldsAreEmpty(){
        //given

        for (int i = 0; i <BOARD_SIZE ; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                //when
                FieldState state = game.getFieldStatus(i, j);
                //then
                assertEquals(FieldState.EMPTY, state);
            } } }

    @Test
    public void myFirstXWasChoosen(){


        //when
        game.putMark(0,0);
        //then
        assertEquals(FieldState.X,game.getFieldStatus(0,0));
    }

    @Test
    public void secondActionWasO(){


        //when
        game.putMark(0,0);
        game.putMark(0,1);
        //then
        assertEquals(FieldState.O,game.getFieldStatus(0,1));
    }

    @Test
    public void youCanNotChooseThisSameField(){
        //given
        game.putMark(0,0);
        //when
        //then
        assertThrows(FieldTakenException.class, ()->game.putMark(0,0));
    }



    @Test
    public void outOfBoardTOP(){
        //when then
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> game.putMark(0,-1));
    }
    @Test
    public void outOfBoardDOWN(){
        //when then
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> game.putMark(0,3));
    }
    @Test
    public void outOfBoardLEFT(){
        //when then
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> game.putMark(-1,0));
    }
    @Test
    public void outOfBoardRIGHT(){
        //when then
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> game.putMark(0,3));
    }

    @Test
    public void playerXWinsHorizontally(){
        //given
        game.putMark(1,0);
        game.putMark(2,0);
        game.putMark(1,1);
        game.putMark(2,2);
        game.putMark(1,2);

        game.refreshView();
        //when
        TTTResult result = game.checkResult();
        //then
        assertEquals(TTTResult.PLAYER_X_WIN,result);

    }
    @Test
    public void playerXWinsVertically(){
        //given
        game.putMark(0,0);
        game.putMark(2,1);
        game.putMark(1,0);
        game.putMark(2,2);
        game.putMark(2,0);

        game.refreshView();
        //when
        TTTResult result = game.checkResult();
        //then
        assertEquals(TTTResult.PLAYER_X_WIN,result);

    }
    @Test
    public void playerOWinsVertically(){
        //given
        game.putMark(1,1);
        game.putMark(0,0);
        game.putMark(2,1);
        game.putMark(1,0);
        game.putMark(2,2);
        game.putMark(2,0);

        game.refreshView();
        //when
        TTTResult result = game.checkResult();
        //then
        assertEquals(TTTResult.PLAYER_O_WIN,result);

    }

    @Test
    public void playerXWinsNaSkos(){
        //given
        game.putMark(0,0);
        game.putMark(2,0);
        game.putMark(1,1);
        game.putMark(2,1);
        game.putMark(2,2);

        game.refreshView();
        //when
        TTTResult result = game.checkResult();
        //then
        assertEquals(TTTResult.PLAYER_X_WIN,result);

    }

    @Test
    public void nobodyWin(){
        //given
        game.putMark(0,1);
        game.putMark(0,0);
        game.putMark(1,2);
        game.putMark(1,0);
        game.putMark(1,1);
        game.putMark(0,2);
        game.putMark(2,0);
        game.putMark(2,1);
        game.putMark(2,2);

        game.refreshView();
        //when
        TTTResult result = game.checkResult();
        //then
        assertEquals(TTTResult.DRAW,result);
    }
    @Test
    public void isSomebodyStillGaming(){
        //given
        game.putMark(0,1);
        game.putMark(0,0);
        game.putMark(1,2);
        game.putMark(1,0);
        game.putMark(1,1);
        game.putMark(0,2);
        game.putMark(2,0);
        game.putMark(2,1);

        game.refreshView();
        //when
        TTTResult result = game.checkResult();
        //then
        assertEquals(TTTResult.GAME_IN_PROGRESS,result);
    }



}