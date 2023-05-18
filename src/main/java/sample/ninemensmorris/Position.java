package sample.ninemensmorris;

import javafx.scene.shape.Shape;

public class Position implements HasShape{

    private Position[] neighbours;
    private Shape shape;

    public Position(Shape shape) {
        this.shape = shape;
    }

    // use this to get the index for corresponding neighbour in the self.neighbours array
    final int TOP = 0;
    final int BOTTOM = 1;
    final int LEFT = 2;
    final int RIGHT = 3;


    @Override
    public Shape getShape() {
        return shape;
    }

    @Override
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setNeighbours(Position[] neighbours) {
        this.neighbours = neighbours;
    }

    public Position getTopNeighbour()
    {
        return neighbours[TOP];
    }
    public Position getBottomNeighbour()
    {
        return neighbours[BOTTOM];
    }
    public Position getLeftNeighbour()
    {
        return neighbours[LEFT];
    }
    public Position getRightNeighbour()
    {
        return neighbours[RIGHT];
    }


    public boolean isNeighbourTo(Position position)
    {
        if ( getTopNeighbour() == position || getRightNeighbour() == position || getBottomNeighbour() == position || getLeftNeighbour() == position)
        {
            return true;
        }
        return false;
    }
}