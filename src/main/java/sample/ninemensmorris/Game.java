package sample.ninemensmorris;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Game {

    private Board board;
    private Player winner;
    private Player player2;
    private Player player1;
    private FxController controller;
    private Display display;
    private int turn = 0;

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
    }



    public boolean executeMove(Token token, Position destination)
    {
        // get the player making the move
        Player currentPlayer = getPlayerTurn();

        //verify if it is the correct turn
        if (currentPlayer.getTokenColour() != token.getColour())
        {
            return false;
        }

        // current player create a move







        display.displayMoveToken(token.getShape(), destination.getShape());
        iterateTurn();
        return true;
    }

    public Boolean isGameOver(Game game){
        //if game is over
        return true;
    }

    public Player getWinner(Player player){
        //get the winner
        return player;
    };

    //iterate the turn of the game
    public void iterateTurn(Player player, Token token){
    }


    //player click on option button
    public void executeOptionButton(){
    }

    public void executeMove(){
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
