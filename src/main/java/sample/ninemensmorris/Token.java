package sample.ninemensmorris;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Shape;

public class Token implements HasShape {

    private Shape shape;

    private TokenColour colour;
    private List<TokenCapability> capabilities = new ArrayList<>();

    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<TokenCapability> getCapabilities() {
        return capabilities;
    }

    public TokenColour getColour() {
        return colour;
    }

    public Token(Shape shape, TokenColour colour, Position position) {
        this.shape = shape;
        this.colour = colour;
        this.position = position;
        this.capabilities.add(TokenCapability.PLAYABLE);
    }

    public void removeCapability(TokenCapability capability)
    {
        capabilities.remove(capability);
    }

    @Override
    public Shape getShape() {
        return shape;
    }

    @Override
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public boolean isTokenPlayable()
    {
        return capabilities.contains(TokenCapability.PLAYABLE);
    }


}

