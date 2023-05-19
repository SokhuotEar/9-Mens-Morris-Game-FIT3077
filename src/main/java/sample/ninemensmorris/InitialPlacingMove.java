package sample.ninemensmorris;

import javafx.scene.control.Label;

public class InitialPlacingMove extends MoveAction {


    /**
     * constructor
     *
     * @param player
     **/
    public InitialPlacingMove(Player player) {
        super(player);
    }

    @Override
    public boolean validateMove(Board board, Token token, Position endingLocation, Label ErrorMessage) {
        if (token.getPosition() == null) {
            return true;
        }
        System.out.println("wrong placing move");
        ErrorMessage.setText("wrong placing move");
        ErrorMessage.setVisible(true);
        return false;
    }
}
