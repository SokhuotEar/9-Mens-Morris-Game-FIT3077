package sample.ninemensmorris;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.scene.paint.Color;

public class TutorialGame implements Initializable {

    @FXML
    private Label TitleMessage;

    @FXML
    private Label TurnMessage;


    @FXML
    private Label InstructionText;

    @FXML
    private Text player1Text;

    @FXML
    private Text player2Text;


    PlayerNameHolder data = PlayerNameHolder.getInstance();

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

    @FXML
    private Button NextButton;

    @FXML
    private Button PreviousButton;

    @FXML
    private Button PlayButton;

    @FXML
    private Shape NextChapter;


    @FXML
    private Shape PreviousChapter;

    private int ChapterCount =1;
    private int PageCount =1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupNextButton(NextButton);
        setupPreviousButton(PreviousButton);
        setupNextChapterButton(NextChapter);
        setupPreviousChapterButton(PreviousChapter);




    }

    private void setupNextButton(Button button){
        button.setOnMouseClicked(mouseEvent -> {
            System.out.println("NextButtonPressed");

            PageCount++;


        });
    }

    private void setupPreviousButton(Button button){
        button.setOnMouseClicked(mouseEvent -> {
            System.out.println("PreviousButtonPressed");

            PageCount--;


        });
    }


    private void setupNextChapterButton(Shape shape){
        shape.setOnMouseClicked(mouseEvent -> {
            System.out.println("NextChapterButtonPressed");

            ChapterCount++;


        });
    }

    private void setupPreviousChapterButton(Shape shape){
        shape.setOnMouseClicked(mouseEvent -> {
            System.out.println("PreviousChapterButtonPressed");

            ChapterCount--;


        });
    }



    public void setupPlayButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("WelcomeUI.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
}
