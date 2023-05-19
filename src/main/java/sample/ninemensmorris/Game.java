package sample.ninemensmorris;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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



    public boolean executeMove(Token token, Position destination, Label MillText, Shape MillButton)
    {
        // get the player making the move
        Player currentPlayer = getPlayerTurn();

        //verify if it is the correct turn
        if (currentPlayer.getTokenColour() != token.getColour())
        {
            return false;
        }

        // get game stage
        boolean success = false;
        if (gameStage == GameStage.INITIAL_PLACEMENT) {
            InitialPlacingMove move = new InitialPlacingMove(currentPlayer);
            success = move.applyMove(board, token,destination);

        }

        else if (gameStage == GameStage.SLIDING_MOVE) {

            if(token.getColour() == TokenColour.WHITE){
                if (board.haveThreeTokenLeftOnBoard()== 1|| board.haveThreeTokenLeftOnBoard()== 0)
                {
                    // white token can do jump move
                    JumpMove move = new JumpMove(currentPlayer);
                    success = move.applyMove(board, token, destination);
                }
                else {
                    SlideMove move = new SlideMove(currentPlayer);
                    success = move.applyMove(board, token, destination);
                }

            }

            if(token.getColour() == TokenColour.BLACK){
                if (board.haveThreeTokenLeftOnBoard()== 2 || board.haveThreeTokenLeftOnBoard()== 0)
                {
                    // white token can do jump move
                    JumpMove move = new JumpMove(currentPlayer);
                    success = move.applyMove(board, token, destination);
                }
                else {
                    SlideMove move = new SlideMove(currentPlayer);
                    success = move.applyMove(board, token, destination);
                }

            }

        }

        else if(gameStage == GameStage.REMOVE_MOVE){
            RemoveMove move = new RemoveMove(currentPlayer);
            success = move.applyMove(board, token,destination);
            if(success){
                display.displayRemoveToken(token.getShape());
                gameStage= GameStage.INITIAL_PLACEMENT;
                MillButton.setVisible(false);
                MillText.setVisible(false);
                return true;
            }

        }

        if (board.determineMill(destination, token))
        {
            System.out.println("Mill");
            MillText.setVisible(true);
            MillButton.setVisible(true);
            gameStage = GameStage.REMOVE_MOVE;



            //TO DO: remove the Mill text
//            MillText.setVisible(false);
        }

        if (success)
        {
                iterateTurn();
                display.displayMoveToken(token.getShape(), destination.getShape());
                return true;
        }





        return success;
    }


    public Boolean isGameOver(Game game){
        //if game is over
        if (gameStage == GameStage.FINISHED)
        {
            return true;
        }
        return false;
    }

    public Player getWinner(Player player){
        //get the winner
        return player;
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

        if (gameStage == GameStage.REMOVE_MOVE)
        {


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


}
