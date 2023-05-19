package sample.ninemensmorris;

public class Player {

    private String name;
    private Token[] tokens = new Token[9];
    private TokenColour tokenColour;

    public Player(String name, TokenColour tokenColour) {
        this.name = name;
        this.tokenColour = tokenColour;
    }

    public String getName() {
        return name;
    }

    public TokenColour getTokenColour() {
        return tokenColour;
    }

    //get the name of the token
    public String getToken(Token token){
        return "token name";
    }


}
