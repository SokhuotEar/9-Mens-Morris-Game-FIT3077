package sample.ninemensmorris;

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
    public boolean validateMove(Board board, Token token, Position endingLocation) {
        if (token.getPosition() == null) {
            return true;
        }

        return false;
    }

    @Override
    public void setErrorMessage() {
        errorMessage = "Wrong placing move";
    }
}
