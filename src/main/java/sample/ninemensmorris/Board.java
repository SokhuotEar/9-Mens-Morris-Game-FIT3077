package sample.ninemensmorris;



public class Board {

    private Position[] positions = new Position[24] ;
    private Token[] whiteTokens = new Token[9];
    private Token[] blackTokens = new Token[9];

    public Board() {
        // create positions

        for (int i=0; i < 24; i++)
        {
            //create a new position
            Position position = new Position(null);
            positions[i] = position;
        }

        // create white tokens
        for (int i=0; i < 9; i++)
        {
            //create a new token
            Token token = new Token(null, TokenColour.WHITE, null);
            whiteTokens[i] = token;
        }

        // create black tokens
        for (int i= 0; i < 9; i++)
        {
            //create a new token
            Token token = new Token(null, TokenColour.BLACK, null);
            blackTokens[i] = token;
        }
    }

    public Position[] getPositions() {
        return positions;
    }

    public Token[] getWhiteTokens() {
        return whiteTokens;
    }

    public Token[] getBlackTokens() {
        return blackTokens;
    }

    public boolean validateMove(Token token, Position destination)
    {
        return true;
    }
}
