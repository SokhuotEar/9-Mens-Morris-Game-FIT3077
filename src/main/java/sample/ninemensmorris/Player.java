package sample.ninemensmorris;

public class Player {

    private String name;
    private Token[] tokens = new Token[9];

    //get the name of the token
    public String getToken(Token token){
        return "token name";
    }

    public MoveAction createMove() {
        return new SlideMove(this);
    }
}
