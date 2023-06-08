package sample.ninemensmorris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.effect.Glow;

import java.util.ArrayList;

public class Display {

    private ArrayList<Shape> shapeToReset = new ArrayList<>();

    // display moves
    public void displayMoveToken(Shape tokenShape, Shape positionShape){
        tokenShape.setLayoutX(positionShape.getLayoutX());
        tokenShape.setLayoutY(positionShape.getLayoutY());
    }

    // display remove token
    public void displayRemoveToken(Shape token){
        token.setVisible(false);
//        token.removeEventHandler();
    }

    // glow up shapes for hints
    public void glowUpShape(Shape shape){

        shape.setStroke(Color.BLUEVIOLET);
        shape.setStrokeWidth(3);

        shapeToReset.add(shape);
    }

    // reset the glow up of hints
    public void resetShapeColour()
    {
        for (Shape shape: shapeToReset) {
            shape.setStroke(Color.web("#d0d0d0"));
        }
        shapeToReset = new ArrayList<>();
    }

}
