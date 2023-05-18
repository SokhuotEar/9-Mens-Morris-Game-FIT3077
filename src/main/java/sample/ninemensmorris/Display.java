package sample.ninemensmorris;

import javafx.scene.shape.Shape;

public class Display {

    public void displayMoveToken(Shape tokenShape, Shape positionShape){
        tokenShape.setLayoutX(positionShape.getLayoutX());
        tokenShape.setLayoutY(positionShape.getLayoutY());
    }

//    public void displayRemoveToken(Shape token){
//        token.setLayoutX(874);
//        token.setLayoutY(387);
//        token.removeEventHandler();
//    }

}
