package TicTacToe;

public class FieldTakenException extends RuntimeException {

    public FieldTakenException() {
    }

    public FieldTakenException(String message) {
        super(message);
    }

    public FieldTakenException(int x, int y) {
        super(String.format(("%dx%d is taken"),x,y));
    }
}
