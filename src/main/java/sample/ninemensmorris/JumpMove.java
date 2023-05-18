package sample.ninemensmorris;

public class JumpMove extends MoveAction{
    protected Player player;
    public JumpMove(Player player) {
        super(player);
    }


//    @Override
//    public boolean validateMove(Board board, Token token, Position endingLocation) {
//        if (token.getCapabilities().contains(TokenCapability.JUMP))
//        {
//            return true;
//        }
//        return false;
//    }
}
