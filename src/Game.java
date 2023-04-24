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

}
