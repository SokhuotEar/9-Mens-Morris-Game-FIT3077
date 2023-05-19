package sample.ninemensmorris;

import javafx.scene.control.Label;

import java.util.Objects;

public class MoveAction {

    protected Player player;

    /** constructor **/
    public MoveAction(Player player) {
        this.player = player;
    }

    /** executes the move **/
    public boolean applyMove(Board board, Token token, Position endingLocation, Label ErrorMessage)
    {
        // input validation
        Objects.requireNonNull(token);
//        Objects.requireNonNull(endingLocation);

        if (validateMove(board, token, endingLocation, ErrorMessage) == true)
        {
            // execute move
            token.setPosition(endingLocation);
            return true;
        }

        return false;
    }


    public boolean validateMove(Board board, Token token, Position endingLocation, Label ErrorMessage)
    {
        return true;
    }


}
