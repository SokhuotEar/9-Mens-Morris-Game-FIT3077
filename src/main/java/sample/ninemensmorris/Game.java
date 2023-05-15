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


    public void executeMove(Player player, Token token, Position destination)
    {
        if (!board.validateMove(token, destination)) {
            return;
        }

        //player creates move
        MoveAction move = player.createMove();

        // game execute move
        move.executeMove(board, token, destination);
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
