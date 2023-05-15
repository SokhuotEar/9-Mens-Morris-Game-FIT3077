package sample.ninemensmorris;

import javafx.scene.shape.Shape;

public class Position implements HasShape{

    private Position[] neighbours;
    private Shape shape;

    public Position(Shape shape) {
        this.shape = shape;
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