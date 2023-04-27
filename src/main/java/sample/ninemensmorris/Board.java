package sample.ninemensmorris;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Board implements Initializable {

    @FXML
    private Label welcomeText;

    // buttons represent positions
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

    @FXML
    private Shape WhiteToken6;

    @FXML
    private Shape WhiteToken7;

    @FXML
    private Shape WhiteToken8;

    @FXML
    private Shape WhiteToken9;

//more tokens to be added here



    @FXML
    private Shape BlackToken1;

    @FXML
    private Shape BlackToken2;

    @FXML
    private Shape BlackToken3;

    @FXML
    private Shape BlackToken4;

    @FXML
    private Shape BlackToken5;

    @FXML
    private Shape BlackToken6;

    @FXML
    private Shape BlackToken7;

    @FXML
    private Shape BlackToken8;

    @FXML
    private Shape BlackToken9;


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
            setupPosition(shape);
            shape.setFocusTraversable(false);

        });

        tokens =new ArrayList<>(Arrays.asList(WhiteToken1,WhiteToken2, WhiteToken3, WhiteToken4, WhiteToken5,WhiteToken6, WhiteToken7, WhiteToken8, WhiteToken9,
                BlackToken1, BlackToken2, BlackToken3, BlackToken4,BlackToken5,BlackToken6,BlackToken7,BlackToken8,BlackToken9));

        tokens.forEach(shape -> {
            setupToken(shape);
            shape.setFocusTraversable(false);

        });

    }
    private void setupPosition(Shape shape) {
        shape.setOnMouseClicked(mouseEvent -> {
            LayoutX = (int) shape.getLayoutX();
            LayoutY = (int) shape.getLayoutY();
            if(CurrentToken==null){
                System.out.println("Please select token first");
            }else {
                MoveToken(CurrentToken, LayoutX, LayoutY);
            }
            shape.setDisable(false);
            //checkIfGameIsOver();
        });

    }

    //check colour of token

//    public String checkColour(Shape token){
//        if(token.getFill() == Color.WHITE){
//            return "WHITE";
//        }
//        else {
//            return "BLACK";
//        }
//
//
//    }

    private void setupToken(Shape shape) {
        shape.setOnMouseClicked(mouseEvent -> {
            CurrentToken = shape;
            shape.setDisable(false);
            //checkIfGameIsOver();
        });

    }

    public void MoveToken(Shape shape, int LayoutX, int LayoutY){

            shape.setLayoutX(LayoutX);
            shape.setLayoutY(LayoutY);
            CurrentToken= null;

    }


    public boolean validateMove(Token token, Position destination) {
        return true;
    }




}