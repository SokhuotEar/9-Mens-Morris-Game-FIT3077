package sample.ninemensmorris;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Label welcomeText;

    @FXML
    private Button button1;

    @FXML
    private Button button2;
    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button button10;

    @FXML
    private Button button11;

    @FXML
    private Button button12;

    @FXML
    private Button button13;

    @FXML
    private Button button14;

    @FXML
    private Button button15;

    @FXML
    private Button button16;

    @FXML
    private Button button17;

    @FXML
    private Button button18;

    @FXML
    private Button button19;

    @FXML
    private Button button20;

    @FXML
    private Button button21;

    @FXML
    private Button button22;

    @FXML
    private Button button23;

    @FXML
    private Button button24;

    ArrayList<Button> buttons;

    private int playerTurn =0;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        buttons =new ArrayList<>(Arrays.asList(button1,button2, button3, button4, button5, button6, button7, button8, button9, button10
        , button11, button12, button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24));

        buttons.forEach(button -> {
            setupButton(button);
            button.setFocusTraversable(false);

        });

    }
    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(true);
            //checkIfGameIsOver();
        });

    }


    public void setPlayerSymbol(Button button){
        if(playerTurn %2 ==0){
            button.setStyle("-fx-background-color: #FFFFFF;");
            playerTurn =1;

        }
        else {
            button.setStyle("-fx-background-color: #000000;");
            playerTurn = 0;

        }

    }
}