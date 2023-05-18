package sample.ninemensmorris;

public class SlideMove extends MoveAction{
    protected Player player;
    public SlideMove(Player player) {
        super(player);
    }

    @Override
    public boolean validateMove(Board board, Token token, Position endingLocation) {
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

        return false;
    }
}
