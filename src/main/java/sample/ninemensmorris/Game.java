package sample.ninemensmorris;

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


}
