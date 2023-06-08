package sample.ninemensmorris;

import java.util.List;
import java.util.ArrayList;

public class Board {

    private Position[] positions = new Position[24];
    private Token[] whiteTokens = new Token[9];
    private Token[] blackTokens = new Token[9];
    private Position[][] map;
    private Position emptyPosition = new EmptyPosition(null);

    // This method initialises the board
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

        configureNeighbourForPosition();
    }

    // this method finds all the neighbours of a position and store that information in position.neighbour.
    private void configureNeighbourForPosition()
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

    // this method finds all the white tokens that are playable (haven't been removed from the board yet)
    public List<Token> getPlayableWhiteToken(){
        List<Token> playableWhiteTokens = new ArrayList<>();

        for (Token token : whiteTokens) {
            if (token.isTokenPlayable()) {
                playableWhiteTokens.add(token);
            }
        }

        return playableWhiteTokens;
    }

    // this method finds all the black tokens that are playable (haven't been removed from the board yet)
    public List<Token> getPlayableBlackToken(){
        List<Token> playableBlackTokens = new ArrayList<>();

        for (Token token : blackTokens) {
            if (token.isTokenPlayable()) {
                playableBlackTokens.add(token);
            }
        }

        return playableBlackTokens;
    }

    // this method finds whether a white token is at a certain position
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

    // this method finds whether a black token is at a certain position
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

    // this method determines whether all the tokens hae been placed
    public boolean haveAllTokenBeenPlaced()
    {
        for (Token token: getPlayableWhiteToken())
        {
            if (token.getPosition() == null) {
                return false;
            }
        }
        for (Token token: getPlayableBlackToken())
        {
            if (token.getPosition() == null) {
                return false;
            }
        }
        return true;
    }

    // this method determines whether there are 3 tokens left of board
    //0 -> both white and black token have three pieces left
    // 1 -> white token has three pieces left
    // 2-> black token has three pieces left
    // 3 -> both black and white token have more than three pieces left
    public int haveThreeTokenLeftOnBoard()
    {
        int output;
        //0 -> both white and black token have three pieces left
        // 1 -> white token has three pieces left
        // 2-> black token has three pieces left
        // 3 -> both black and white token have more than three pieces left

        int NumberofWhiteToken=0;
        int NumberofBlackToken=0;
        for (Token token: getPlayableWhiteToken())
        {
            if (token.getPosition() != null) {
                NumberofWhiteToken++;
            }
        }

        for (Token token: getPlayableBlackToken())
        {
            if (token.getPosition() != null) {
                NumberofBlackToken++;
            }
        }
        if(NumberofWhiteToken ==3 && NumberofBlackToken ==3){
            setBlackCanJump();
            setBlackCanJump();
            output = 0;
            return output;
        }
        if(NumberofWhiteToken ==3){
            setWhiteCanJump();
            output= 1;
            return output;
        }
        if(NumberofBlackToken ==3){
            setBlackCanJump();
            output =2;
            return output;
        }
        output =3;
        return output;
    }

    // this method sets the jump capability of all playable white tokens
    public void setWhiteCanJump()
    {
        for (Token token: whiteTokens)
        {
            token.addCapability(TokenCapability.JUMP);
        }
    }

    // this method sets the jump capability of all playable black tokens
    public void setBlackCanJump()
    {
        for (Token token: blackTokens)
        {
            token.addCapability(TokenCapability.JUMP);
        }
    }

    // this method determines whether there is a mill
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

    // this method finds the index [col, row] of a position with regards to map array.
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

    // this method looks at the board and determines if a player has won
    public boolean isGameFinished(TokenColour colour)
    {
        if (getPlayableWhiteToken().size() <= 2 || getPlayableBlackToken().size() <= 2)
        {
            return true;
        }

        if (!hasAvailableMove(colour))
        {
            return true;
        }
        return false;
    }

    // this method looks at the board and determines who is a winner
    public TokenColour getWinningColour()
    {
        if (getPlayableBlackToken().size() <= 2)
        {
            return TokenColour.WHITE;
        }
        else if (getPlayableWhiteToken().size() <= 2)
        {
            return TokenColour.BLACK;
        }
        else
        {
            return null;
        }
    }

    // this method determine if black or white has any available moves to determine win condition
    public boolean hasAvailableMove(TokenColour tokenColour) {
        if (tokenColour == TokenColour.WHITE) {
            for (Token token : getPlayableWhiteToken()) {
                if (token.getCapabilities().contains(TokenCapability.JUMP))
                {
                    return true;
                }
                Position position = token.getPosition();
                for (Position neighbour : position.getNeighbours()) {
                    if (!isWhiteTokenAt(neighbour) && !isBlackTokenAt(neighbour)) {
                        return true;
                    }
                }

            }
        }

        else if (tokenColour == TokenColour.BLACK) {
            for (Token token : getPlayableBlackToken()) {
                if (token.getCapabilities().contains(TokenCapability.JUMP))
                {
                    return true;
                }
                Position position = token.getPosition();
                for (Position neighbour : position.getNeighbours()) {
                    if (!isWhiteTokenAt(neighbour) && !isBlackTokenAt(neighbour)) {
                        return true;
                    }
                }

            }
        }

        return false;
    }

    // this method will return black or white playable token arrays depending on whose turn it is
    public List<Token> getTokensThisTurn(TokenColour tokenColour)
    {
        if (tokenColour == TokenColour.BLACK)
        {
            return getPlayableBlackToken();
        }
        else{
            return getPlayableWhiteToken();
        }
    }

    // this method will return black or white playable token arrays that have not been played
    public List<Token> getNonPlacedToken(TokenColour tokenColour)
    {
        List<Token> tokens = getTokensThisTurn(tokenColour);
        List<Token> returnTokens = getTokensThisTurn(tokenColour);

        for (Token token: tokens)
        {
            if ((token.getPosition() == null) && (token.getCapabilities().contains(TokenCapability.PLAYABLE) ))
            {
                returnTokens.add(token);
            }
        }
        return returnTokens;
    }

    // this method get positions with no tokens on it
    public List<Position> getEmptyPositions()
    {
        ArrayList<Position> emptyPositions = new ArrayList<>();
        for (Position position : positions)
        {
            if (!isBlackTokenAt(position) && !isWhiteTokenAt(position))
            {
                emptyPositions.add(position);
            }

        }
        return emptyPositions;
    }

    // this method looks at a positions and get empty neighbours of the position
    public ArrayList<Position> getEmptyNeighboursOf(Position position)
    {
        ArrayList <Position> emptyNeighbours = new ArrayList<>();

        for (Position neighbour: position.getNeighbours())
        {
            if (!isWhiteTokenAt(neighbour) && !isBlackTokenAt(neighbour))
            {
                emptyNeighbours.add(neighbour);
            }
        }
        return emptyNeighbours;
    }

    // returns the tokens that aren't part of a mill
    public ArrayList<Token> getTokenNotInMill(ArrayList<Token> tokens)
    {
        ArrayList <Token> tokenMill = new ArrayList<>();

        for (Token token: tokens){
            if ((token.getPosition() != null) && !determineMill(token.getPosition(), token))
            {
                tokenMill.add(token);
            }
        }
        return tokenMill;
    }




}
