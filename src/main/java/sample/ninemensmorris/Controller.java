package sample.ninemensmorris;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label welcomeText;

    @FXML
    private Shape button1;

    @FXML
    private Shape button2;
    @FXML
    private Shape button3;

    @FXML
    private Shape button4;

    @FXML
    private Shape button5;

    @FXML
    private Shape button6;

    @FXML
    private Shape button7;

    @FXML
    private Shape button8;

    @FXML
    private Shape button9;

    @FXML
    private Shape button10;

    @FXML
    private Shape button11;

    @FXML
    private Shape button12;

    @FXML
    private Shape button13;

    @FXML
    private Shape button14;

    @FXML
    private Shape button15;

    @FXML
    private Shape button16;

    @FXML
    private Shape button17;

    @FXML
    private Shape button18;

    @FXML
    private Shape button19;

    @FXML
    private Shape button20;

    @FXML
    private Shape button21;

    @FXML
    private Shape button22;

    @FXML
    private Shape button23;

    @FXML
    private Shape button24;



    @FXML
    private Shape WhiteToken1;
    @FXML
    private Shape WhiteToken2;

    @FXML
    private Shape WhiteToken3;

    @FXML
    private Shape WhiteToken4;

    @FXML
    private Shape WhiteToken5;

//more tokens to be added here



    @FXML
    private Shape BlackToken1;

    @FXML
    private Shape BlackToken2;

    @FXML
    private Shape BlackToken3;

    @FXML
    private Shape BlackToken4;


    //more tokens to be added here



    ArrayList<Shape> buttons;
    ArrayList<Shape> tokens;

    private int playerTurn =0;

    private int LayoutX;
    private int LayoutY;

    private Shape CurrentToken =null;

//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        buttons =new ArrayList<>(Arrays.asList(button1,button2, button3, button4, button5, button6, button7, button8, button9, button10
        , button11, button12, button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24));

        buttons.forEach(shape -> {
            setupButton(shape);
            shape.setFocusTraversable(false);

        });

        tokens =new ArrayList<>(Arrays.asList(WhiteToken1,WhiteToken2, WhiteToken3, WhiteToken4, WhiteToken5,BlackToken1, BlackToken2
        , BlackToken3, BlackToken4));

        tokens.forEach(shape -> {
            setupToken(shape);
            shape.setFocusTraversable(false);

        });

    }
    private void setupButton(Shape shape) {
        shape.setOnMouseClicked(mouseEvent -> {
            LayoutX = (int) shape.getLayoutX();
            LayoutY = (int) shape.getLayoutY();
            if(CurrentToken==null){
                System.out.println("Please select token first");
            }else {
                setPlayerSymbol(CurrentToken, LayoutX, LayoutY);
            }
            shape.setDisable(false);
            //checkIfGameIsOver();
        });

    }

    private void setupToken(Shape shape) {
        shape.setOnMouseClicked(mouseEvent -> {
            CurrentToken = shape;
            shape.setDisable(false);
            //checkIfGameIsOver();
        });

    }

    public void setPlayerSymbol(Shape shape, int LayoutX, int LayoutY){

            shape.setLayoutX(LayoutX);
            shape.setLayoutY(LayoutY);
            CurrentToken= null;

    }





}