package sample.ninemensmorris;

import javafx.scene.control.Label;

public class SlideMove extends MoveAction{
    protected Player player;
    public SlideMove(Player player) {
        super(player);
    }

    @Override
    public boolean validateMove(Board board, Token token, Position endingLocation, Label ErrorMessage) {
        Position currentPosition = token.getPosition();

        // if the destination position is a neighbour to the current position
        if (currentPosition.isNeighbourTo(endingLocation))
        {
            return true;
        }

        // or if the token can jump
        if (token.getCapabilities().contains(TokenCapability.JUMP)) {
            return true;
        }
        ErrorMessage.setText("You need to do slide move!");
        ErrorMessage.setVisible(true);

        return false;
    }

    @Override
    public void setErrorMessage() {
        errorMessage = "Wrong sliding move";
    }
}
