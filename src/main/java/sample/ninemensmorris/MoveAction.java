package sample.ninemensmorris;

import java.util.Objects;

public abstract class MoveAction {

    protected Player player;

    /** constructor **/
    public MoveAction(Player player) {
        this.player = player;
    }

    /** executes the move **/
    public boolean applyMove(Board board, Token token, Position endingLocation)
    {
        // input validation
        Objects.requireNonNull(token);
        Objects.requireNonNull(endingLocation);

        // execute move
        token.setPosition(endingLocation);
        return true;
    }


    public boolean validateMove(Board board, Token token, Position endingLocation)
    {
        return false;
    }


}
