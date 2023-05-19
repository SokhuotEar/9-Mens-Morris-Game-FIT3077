package sample.ninemensmorris;

import javafx.scene.control.Label;

public class JumpMove extends MoveAction{
    protected Player player;
    public JumpMove(Player player) {
        super(player);
    }


    @Override
    public boolean validateMove(Board board, Token token, Position endingLocation, Label ErrorMessage) {
        if (token.getPosition() != null) {
            return true;
        }
        System.out.println("Wrong Jump move");
        ErrorMessage.setText("You need to do Jump move!");
        ErrorMessage.setVisible(true);
        return false;
    }
}
