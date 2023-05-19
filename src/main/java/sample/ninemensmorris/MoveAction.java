package sample.ninemensmorris;

import java.util.Objects;

public abstract class MoveAction {

    protected Player player;
    protected String errorMessage = null;

    /** constructor **/
    public MoveAction(Player player) {
        this.player = player;
    }

    /** executes the move **/
    public boolean applyMove(Board board, Token token, Position endingLocation)
    {
        // input validation
        Objects.requireNonNull(token);
//        Objects.requireNonNull(endingLocation);

        if (validateMove(board, token, endingLocation) && token.isTokenPlayable())
        {
            // execute move
            token.setPosition(endingLocation);
            return true;
        }

        setErrorMessage();
        return false;
    }


    public boolean validateMove(Board board, Token token, Position endingLocation)
    {
        return false;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage()
    {
        return;
    }




}
