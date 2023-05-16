package sample.ninemensmorris;


import java.util.ArrayList;

public class Board {

    private Position[] positions = new Position[24];
    private Token[] whiteTokens = new Token[9];
    private Token[] blackTokens = new Token[9];

    public Board() {
        // create positions

        for (int i = 0; i < 24; i++) {
            //create a new position
            Position position = new Position(null);
            positions[i] = position;
        }

        // create white tokens
        for (int i = 0; i < 9; i++) {
            //create a new token
            Token token = new Token(null, TokenColour.WHITE, null);
            whiteTokens[i] = token;
        }

        // create black tokens
        for (int i = 0; i < 9; i++) {
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

    public boolean validateMove(Token token, Position destination) {
        return true;
    }
//
//    public boolean detectMill(Token placedToken) {
//        // loop through all the tokens
//        double x_intercept = placedToken.getShape().getLayoutX();
//        double y_intercept = placedToken.getShape().getLayoutY();
//
//        // get token colour
//        TokenColour colour = placedToken.getColour();
//        ArrayList<Token> tokenListX = new ArrayList<>();
//        ArrayList<Token> tokenListY = new ArrayList<>();
//
//        if (colour == TokenColour.BLACK)
//        {
//            tokenListX = getBlackTokensAtX(x_intercept);
//            tokenListY = getBlackTokensAtY(y_intercept);
//        }
//
//        if (colour == TokenColour.WHITE)
//        {
//            tokenListX = getWhiteTokensAtX(x_intercept);
//            tokenListY = getWhiteTokensAtY(y_intercept);
//        }
//
//        if (tokenListX.size() <= 3 || tokenListY.size() <= 3)
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//    }
//
//    public ArrayList<Token> getWhiteTokensAtX(double x_intercept) {
//        ArrayList<Token> tokenListX = new ArrayList<>();
//
//        // loop through all the tokens
//        for (Token token : whiteTokens) {
//            // Code to be executed for each token
//            if (token.getPosition().getShape().getLayoutX() == x_intercept) {
//                tokenListX.add(token);
//            }
//        }
//        return tokenListX;
//    }
//
//    public ArrayList<Token> getWhiteTokensAtY(double y_intercept) {
//        ArrayList<Token> tokenListY = new ArrayList<>();
//
//        // loop through all the tokens
//        for (Token token : whiteTokens) {
//            // Code to be executed for each token
//            if (token.getPosition().getShape().getLayoutY() == y_intercept) {
//                tokenListY.add(token);
//            }
//        }
//        return tokenListY;
//    }
//
//    public ArrayList<Token> getBlackTokensAtX(double x_intercept) {
//        ArrayList<Token> tokenListX = new ArrayList<>();
//
//        // loop through all the tokens
//        for (Token token : blackTokens) {
//            // Code to be executed for each token
//            if (token.getPosition().getShape().getLayoutX() == x_intercept) {
//                tokenListX.add(token);
//            }
//        }
//        return tokenListX;
//    }
//
//    public ArrayList<Token> getBlackTokensAtY(double y_intercept) {
//        ArrayList<Token> tokenListY = new ArrayList<>();
//
//        // loop through all the tokens
//        for (Token token : blackTokens) {
//            // Code to be executed for each token
//            if (token.getPosition().getShape().getLayoutY() == y_intercept) {
//                tokenListY.add(token);
//            }
//        }
//        return tokenListY;
//    }



}
