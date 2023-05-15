package sample.ninemensmorris;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Shape;

public class Token implements HasShape {

    private Shape shape;

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

    public Token(Shape shape, TokenColour colour, Position position) {
        this.shape = shape;
        this.colour = colour;
        this.position = position;
    }

    @Override
    public Shape getShape() {
        return shape;
    }

    @Override
    public void setShape(Shape shape) {
        this.shape = shape;
    }


}

