package sample.ninemensmorris;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.IOException;

public class Game {

    private Board board;
    private Player winner;
    private Player player2;
    private Player player1;
    private Display display;
    private int turn = 0;
    private GameStage gameStage = GameStage.INITIAL_PLACEMENT;
    private boolean hasMill = false;

    public Game() {
        // set up board
        board = new Board();

        // set up players
        winner = null;
        player2 = new Player("Player2", TokenColour.BLACK);
        player1 = new Player("Player1", TokenColour.WHITE);
        display = new Display();
    }

    public Board getBoard() {
        return board;
    }


    private void setUpBoard()
    {

    }



    public Player getPlayerTurn()
    {
        if (turn % 2 == 0)
        {
            return player1;
        }
        else
        {
            return player2;
        }
    }

    public void iterateTurn()
    {
        turn++;
        updateGameStage();
    }

    public String getDisplayTurn()
    {
        return getPlayerTurn().getTokenColour().toString() + " TURN";
    }


    public String executeMove(Token token, Position destination, Label MillText, Shape MillButton) {

        System.out.println(turn);
        // get the player making the move
        Player currentPlayer = getPlayerTurn();

        //verify if it is the correct turn
        if (currentPlayer.getTokenColour() != token.getColour()) {
            return "Wrong turn!";
        }

        if (turn == 6)
        {
            int a = 1;
        }

        // get game stage
        boolean success = false;
        MoveAction move = null;

        if (gameStage == GameStage.FINISHED)
        {
            return winner.getName();
        }
        else if (hasMill) {
            move = new RemoveMove(currentPlayer);
            success = move.applyMove(board, token, destination);
            if (success) {
                token.removeCapability(TokenCapability.PLAYABLE);
                display.displayRemoveToken(token.getShape());
                MillButton.setVisible(false);
                MillText.setVisible(false);
                hasMill = false;
                turn++;
            }
        } else if (gameStage == GameStage.INITIAL_PLACEMENT) {
            move = new InitialPlacingMove(currentPlayer);
            success = move.applyMove(board, token, destination);

        } else if (gameStage == GameStage.SLIDING_MOVE) {

            if (token.getColour() == TokenColour.WHITE) {
                if (board.haveThreeTokenLeftOnBoard() == 1 || board.haveThreeTokenLeftOnBoard() == 0) {
                    // white token can do jump move
                    move = new JumpMove(currentPlayer);
                    success = move.applyMove(board, token, destination);
                } else {
                    move = new SlideMove(currentPlayer);
                    success = move.applyMove(board, token, destination);
                }

            }

            if (token.getColour() == TokenColour.BLACK) {
                if (board.haveThreeTokenLeftOnBoard() == 2 || board.haveThreeTokenLeftOnBoard() == 0) {
                    // white token can do jump move
                    move = new JumpMove(currentPlayer);
                    success = move.applyMove(board, token, destination);
                } else {
                    move = new SlideMove(currentPlayer);
                    success = move.applyMove(board, token, destination);
                }

            }

        }



        if (destination != null && success) {
            if (board.determineMill(destination, token)) {
                hasMill = true;
                System.out.println("Mill");
                MillText.setVisible(true);
                MillButton.setVisible(true);

            }
            display.displayMoveToken(token.getShape(), destination.getShape());

        }
        //TO DO: remove the Mill text
//            MillText.setVisible(false);

        if (success)
        {
            iterateTurn();
            return null;
        }

        return move.getErrorMessage();
    }


    public Boolean isGameOver(Game game){
        //if game is over
        if (gameStage == GameStage.FINISHED)
        {
            return true;
        }
        return false;
    }

    public Player getWinner(){
        //get the winner
        return winner;
    };

    //player click on option button
    public void executeOptionButton(){
    }


    public void updateGameStage()
    {
        if (gameStage == GameStage.INITIAL_PLACEMENT)
        {
            // check if all the tokens have been placed
            if (board.haveAllTokenBeenPlaced())
            {
                gameStage = GameStage.SLIDING_MOVE;
                return;
            }
        }

        if (gameStage == GameStage.SLIDING_MOVE)
        {
            if (board.isGameFinished(getPlayerTurn().getTokenColour()))
            {
                setWinner(board.getWinningColour());
                gameStage = GameStage.FINISHED;
            }
        }
        System.out.println(gameStage);
    }

    private void setWinner(TokenColour tokenColour)
    {
        if (tokenColour == TokenColour.BLACK)
        {
            winner = player2;
        }
        else
        {
            winner = player1;
        }
    }

    // move to Player detail scene button clicked
    public void switchToPlayerDetailScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PlayerDetails.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }

    public boolean isHasMill() {
        return hasMill;
    }
}
