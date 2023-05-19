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
    public boolean validateMove(Board board, Token token, Position endingLocation) {
        if (token.getPosition() != null) {
            return true;
        }
        System.out.println("Error! It's a Mill Move");
        return false;
    }
}
