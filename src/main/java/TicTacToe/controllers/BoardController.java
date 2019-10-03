package TicTacToe.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import TicTacToe.TicTacToe;
import TicTacToe.model.FieldState;
import TicTacToe.model.TTTPositions;
import TicTacToe.model.TTTResult;


public class BoardController  {

    private TicTacToe logic;


    @FXML
    private TextField field;

    @FXML
    private GridPane gridBoard;

    @FXML
    public void initialize(){
        logic = new TicTacToe(null);
        refreshInfoText();
    }

    private void refreshInfoText() {
        TTTResult result = logic.checkResult();
        switch(result){
            case PLAYER_X_WIN:
                field.setText("Player X win");
                disableBoard();
                break;
            case PLAYER_O_WIN:
                field.setText("Player O win");
                disableBoard();
            case GAME_IN_PROGRESS:
                if(logic.isPlayerXTurn()){
                    field.setText("Player X turn");
                } else { field.setText("Player O turn"); }
                break;
            case DRAW:
                field.setText("Draw...");
                disableBoard();
                break;
        }

    }

    private void disableBoard() {
        gridBoard.setDisable(true);
    }

    @FXML
    private void handleBoardClick(ActionEvent event){

        System.out.println(event);
        Object source = event.getSource();
        if(source instanceof Button){
            Button button = (Button) source;
            String id = button.getId();
            TTTPositions positions = idToPosition(id);

            logic.putMark(positions.getX(),positions.getY());
            FieldState state = logic.getFieldStatus(positions.getX(),positions.getY());
            button.setText(state.name());
            button.setDisable(true);
            refreshInfoText();
        }

    }

    private TTTPositions idToPosition(String id) {
        String input = id.replace("button","");
        String[]split = input.split("_");
        if(split.length==2){
            int x = Integer.valueOf(split[0]);
            int y = Integer.valueOf(split[1]);
            return new TTTPositions(x,y);
        }
        return new TTTPositions(-1,-1);
    }


}
