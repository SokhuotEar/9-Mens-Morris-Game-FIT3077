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
        System.out.println("error in initialplacement move");
        return false;
    }
}
