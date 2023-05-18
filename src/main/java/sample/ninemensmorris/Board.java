package sample.ninemensmorris;
import java.util.List;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Objects;

public class Board {

    private Position[] positions = new Position[24];
    private Token[] whiteTokens = new Token[9];
    private Token[] blackTokens = new Token[9];
    private Position[][] map;
    private Position emptyPosition = new EmptyPosition(null);

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

        // create a map
        map = new Position[][]{
                {positions[0], null, null, positions[1], null, null, positions[2]},
                {null, positions[3], null, positions[4], null, positions[5], null},
                {null, null, positions[6], positions[7], positions[8], null, null},
                {positions[9], positions[10], positions[11], emptyPosition, positions[12], positions[13], positions[14]},
                {null, null, positions[15], positions[16], positions[17], null, null},
                {null, positions[18], null, positions[19], null, positions[20], null},
                {positions[21], null, null, positions[22], null, null, positions[23]},
        };

        configureNeighbour();
    }

    private void configureNeighbour()
    {
        int up_index = 0;
        int down_index = 1;
        int left_index = 2;
        int right_index = 3;
        for (Position position: positions)
        {
            Position neighbours[] = new Position[4];
            int[] colRow = getColsAndRowsOf(position);


            // traverse up
            try {
                int col = colRow[0];
                int row = colRow[1];
                Position top = map[row - 1][col];
                while (top == null) {
                    row--;
                    top = map[row][col];

                }
                if (top != emptyPosition) {
                    neighbours[up_index] = top;
                }
            } catch (IndexOutOfBoundsException e) {
                neighbours[up_index] = null;
            }

            // traverse down
            try {
                int col = colRow[0];
                int row = colRow[1];
                Position down = map[row + 1][col];
                while (down == null) {
                    row++;
                    down = map[row][col];

                }
                if (down != emptyPosition) {
                    neighbours[down_index] = down;
                }
            } catch (IndexOutOfBoundsException e) {
                neighbours[down_index] = null;
            }

            // traverse left
            try {
                int col = colRow[0];
                int row = colRow[1];
                Position left = map[row][col-1];
                while (left == null) {
                    col--;
                    left = map[row][col];

                }
                if (left != emptyPosition) {
                    neighbours[left_index] = left;
                }
            } catch (IndexOutOfBoundsException e) {
                neighbours[left_index] = null;
            }

            // traverse right
            try {
                int col = colRow[0];
                int row = colRow[1];
                Position right = map[row][col+1];
                while (right == null) {
                    col++;
                    right = map[row][col];

                }
                if (right != emptyPosition) {
                    neighbours[right_index] = right;
                }
            } catch (IndexOutOfBoundsException e) {
                neighbours[right_index] = null;
            }


            position.setNeighbours(neighbours);

        }
        return;
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


    public boolean isWhiteTokenAt(Position targetPosition){
        for (Token token: whiteTokens)
        {
            if (token.getPosition() == targetPosition)
            {
                return true;
            }
        }

            return false;
    }

    public boolean isBlackTokenAt(Position targetPosition){
        for (Token token: blackTokens)
        {
            if (token.getPosition() == targetPosition)
            {
                return true;
            }
        }

        return false;
    }

    public boolean haveAllTokenBeenPlaced()
    {
        for (Token token: whiteTokens)
        {
            if (token.getPosition() == null) {
                return false;
            }
        }
        for (Token token: blackTokens)
        {
            if (token.getPosition() == null) {
                return false;
            }
        }
        return true;
    }

    public boolean determineMill(Position position, Token token)
    {
        // get neighbours
        List<Position> rowNeighbourList = new ArrayList<>();
        List<Position> columnNeighbourList = new ArrayList<>();

        // in x direction
        Position left = position.getLeftNeighbour();
        while (left != null)
        {
            rowNeighbourList.add(left);
            left = left.getLeftNeighbour();
        }

        Position right = position.getRightNeighbour();
        {
            while (right != null)
            {
                rowNeighbourList.add(right);
                right = right.getRightNeighbour();
            }
        }

        // in y direction
        Position up = position.getTopNeighbour();
        while (up != null)
        {
            columnNeighbourList.add(up);
            up = up.getTopNeighbour();
        }

        Position down = position.getBottomNeighbour();
        {
            while (down != null)
            {
                columnNeighbourList.add(down);
                down = down.getBottomNeighbour();
            }
        }

        // go through the row and column to see if a mill is formed
        boolean rowMill = true;
        boolean columnMill = true;

        // go through the row and column to see if a mill is formed
        for (Position neighbour: rowNeighbourList)
        {
            if (token.getColour() == TokenColour.BLACK)
            {
                if (!isBlackTokenAt(neighbour))
                {
                    rowMill = false;
                }
            }
            else if (token.getColour() == TokenColour.WHITE)
            {
                if (!isWhiteTokenAt(neighbour))
                {
                    rowMill = false;
                }
            }
        }

        for (Position neighbour: columnNeighbourList)
        {
            if (token.getColour() == TokenColour.BLACK)
            {
                if (!isBlackTokenAt(neighbour))
                {
                    columnMill = false;
                }
            }
            else if (token.getColour() == TokenColour.WHITE)
            {
                if (!isWhiteTokenAt(neighbour))
                {
                    columnMill = false;
                }
            }
        }

        if (rowMill || columnMill == true)
        {
            return true;
        }
        return rowMill || columnMill;
    }


    public int[] getColsAndRowsOf(Position position)
    {
        int numRows = map.length;
        int numCols = map[0].length;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (map[row][col] == position) {
                    int result[] = {col, row};
                    return result;
                }
            }
        }

        return null; // Element not found
    }

    public void detectJumpStage()
    {


    }



}
