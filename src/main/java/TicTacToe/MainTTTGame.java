package TicTacToe;

import TicTacToe.model.TTTPositions;
import TicTacToe.model.TTTResult;
import TicTacToe.player.TTTPlayer;
import TicTacToe.player.TTTRandomPlayer;
import TicTacToe.player.TTTScanner;
import TicTacToe.view.ConsoleTTTView;

public class MainTTTGame {

    public static void main(String[] args) {
        TTTPlayer playerX = new TTTScanner();
       // TTTPlayer playerO = new TTTScanner(); ludzki  gracz
        TTTPlayer playerO = new TTTRandomPlayer(); // komputer
        TicTacToe game = new TicTacToe(new ConsoleTTTView());
        TTTPositions positions;
        TTTResult result;
        do{
            if(game.isPlayerXTurn()){
                System.out.println("Ruch gracza X");
                positions= playerX.getMarkPositions(game);
            }
            else{
                System.out.println("Ruch gracza O");
                positions=playerO.getMarkPositions(game);
            }
            try{
            game.putMark(positions.getX(),positions.getY());
            game.refreshView();}
            catch (FieldTakenException field) { System.out.println("To pole jest zajęte!"); }

            result = game.checkResult();

        }while(game.checkResult()== TTTResult.GAME_IN_PROGRESS);

        switch (result) {
            case PLAYER_X_WIN:
                System.out.println("Gracz X wygrywa!");
                break;
            case PLAYER_O_WIN:
                System.out.println("Gracz O wygrywa!");
                break;
            case DRAW:
                System.out.println("Remis!");
                break;
    }
}}
