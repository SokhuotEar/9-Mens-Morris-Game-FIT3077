package sample.ninemensmorris;

public class Game {

    private Board board;
    private Player winner;
    private Player player2;
    private Player player1;
    private FxController controller;
    private Display display;

    public Game() {
        // set up board
        board = new Board();

        // set up players
        winner = null;
        player2 = new Player();
        player1 = new Player();
        display = new Display();
    }

    public Board getBoard() {
        return board;
    }

    private void setUpBoard()
    {

    }

    public void executeMove(Player player, Token token, Position destination)
    {
//        if (!board.validateMove(token, destination)) {
//            return;
//        }
//
//        //player creates move
//        MoveAction move = player.createMove();


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
