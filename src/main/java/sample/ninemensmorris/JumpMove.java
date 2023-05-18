package sample.ninemensmorris;

public class JumpMove extends MoveAction{
    protected Player player;
    public JumpMove(Player player) {
        super(player);
    }


    @Override
    public boolean validateMove(Board board, Token token, Position endingLocation) {
        if (token.getPosition() != null) {
            return true;
        }
        System.out.println("error in initialplacement move");
        return false;
    }
}
