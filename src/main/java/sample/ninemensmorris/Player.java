package sample.ninemensmorris;

public class Player {

    private String name;
    private Token[] tokens = new Token[9];

    public Player() {
    }

    public MoveAction createMove() {
        return new Move(this);
    }
}
