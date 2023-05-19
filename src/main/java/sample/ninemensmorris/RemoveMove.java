package sample.ninemensmorris;

import javafx.scene.control.Label;

public class RemoveMove extends MoveAction {
    /**
     * constructor
     *
     * @param player
     **/
    public RemoveMove(Player player) {
        super(player);
    }

    @Override
    public boolean validateMove(Board board, Token token, Position endingLocation, Label ErrorMessage) {
        if (token.getPosition() != null) {
            return true;
        }
        ErrorMessage.setText("Error! It's a Mill Move");
        System.out.println("Error! It's a Mill Move");
        ErrorMessage.setVisible(true);
        return false;
    }
}
