import java.util.ArrayList;
import java.util.List;

public class Token {
    private TokenColour colour;
    private List<Capability> items = new ArrayList<>();

    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public TokenColour getColour() {
        return colour;
    }
}
