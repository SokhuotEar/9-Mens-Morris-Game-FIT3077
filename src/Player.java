import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Token[] tokens = new Token[9];


    public MoveAction createMove() {
        return new Move(this);
    }

}
