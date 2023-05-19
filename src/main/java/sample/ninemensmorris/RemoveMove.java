package sample.ninemensmorris;

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
    public boolean applyMove(Board board, Token token, Position endingLocation) {

        return super.applyMove(board, token, endingLocation);
    }

    @Override
    public boolean validateMove(Board board, Token token, Position endingLocation) {

        // if the position of the token to remove is not null
        // and if the token to remove is not part of a mill
        if (token.getPosition() != null && !board.determineMill(token.getPosition(), token)) {
            return true;
        }


        System.out.println("Error! It's a Mill Move");
        return false;
    }

    @Override
    public void setErrorMessage() {
        errorMessage = "Cannot remove token not part of a mill";
    }


}
