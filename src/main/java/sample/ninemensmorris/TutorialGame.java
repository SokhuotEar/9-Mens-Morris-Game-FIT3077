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
import javafx.scene.shape.Line;
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

    @FXML
    private Shape Circle;

    @FXML
    private Shape Circle2;

    @FXML
    private javafx.scene.shape.Line Line;

    @FXML
    private Shape Cross1;

    @FXML
    private Shape Cross2;

    private int ChapterCount =1;
    private int PageCount =1;

    private int CurrentPage;
    private int CurrentChapter;

    private int i;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupNextButton(NextButton);
        setupPreviousButton(PreviousButton);
        setupNextChapterButton(NextChapter);
        setupPreviousChapterButton(PreviousChapter);
        Circle.setVisible(false);
        Circle2.setVisible(false);
        Line.setVisible(false);
        Cross1.setVisible(false);
        Cross2.setVisible(false);
        checkScene();




    }

    private void checkScene(){

        if(ChapterCount==1){
            if(PageCount == 1){
                InstructionText.setTextFill(Color.GREEN);
                TitleMessage.setText("1.Place Token");
                WhiteToken1.setVisible(true);
                WhiteToken2.setVisible(true);
                WhiteToken3.setVisible(true);
                WhiteToken4.setVisible(true);
                WhiteToken5.setVisible(true);
                WhiteToken6.setVisible(true);
                WhiteToken1.setVisible(true);
                WhiteToken7.setVisible(true);
                WhiteToken8.setVisible(true);
                WhiteToken9.setVisible(true);


                BlackToken1.setVisible(true);
                BlackToken2.setVisible(true);
                BlackToken3.setVisible(true);
                BlackToken4.setVisible(true);
                BlackToken5.setVisible(true);
                BlackToken6.setVisible(true);
                BlackToken7.setVisible(true);
                BlackToken8.setVisible(true);
                BlackToken9.setVisible(true);

                WhiteToken1.setLayoutX(803);
                WhiteToken1.setLayoutY(217);
                WhiteToken2.setLayoutX(870);
                WhiteToken2.setLayoutY(217);
                WhiteToken3.setLayoutX(937);
                WhiteToken3.setLayoutY(217);
                WhiteToken4.setLayoutX(803);
                WhiteToken4.setLayoutY(283);
                WhiteToken5.setLayoutX(870);
                WhiteToken5.setLayoutY(278);
                WhiteToken6.setLayoutX(937);
                WhiteToken6.setLayoutY(276);
                WhiteToken7.setLayoutX(803);
                WhiteToken7.setLayoutY(338);
                WhiteToken8.setLayoutX(870);
                WhiteToken8.setLayoutY(338);
                WhiteToken9.setLayoutX(937);
                WhiteToken9.setLayoutY(338);

                BlackToken1.setLayoutX(803);
                BlackToken1.setLayoutY(590);
                BlackToken2.setLayoutX(870);
                BlackToken2.setLayoutY(590);
                BlackToken3.setLayoutX(937);
                BlackToken3.setLayoutY(590);
                BlackToken4.setLayoutX(803);
                BlackToken4.setLayoutY(649);
                BlackToken5.setLayoutX(870);
                BlackToken5.setLayoutY(649);
                BlackToken6.setLayoutX(937);
                BlackToken6.setLayoutY(649);
                BlackToken7.setLayoutX(803);
                BlackToken7.setLayoutY(707);
                BlackToken8.setLayoutX(870);
                BlackToken8.setLayoutY(707);
                BlackToken9.setLayoutX(937);
                BlackToken9.setLayoutY(707);




                Circle.setVisible(true);
                Line.setVisible(true);
                Line.setLayoutX(582);
                Line.setLayoutY(259);
                Line.setStartX(-38.7);
                Line.setStartY(49);
                Line.setEndX(166.7);
                Line.setEndY(-43.7);
                Circle.setLayoutX(803);
                Circle.setLayoutY(217);
                Circle2.setVisible(false);
                Cross1.setVisible(false);
                Cross2.setVisible(false);
                InstructionText.setText("To start the game, you need to place a token at any available positions. White token starts first.");

            }

            if(PageCount == 2){
                Circle.setVisible(false);
                Line.setVisible(false);
                InstructionText.setText("Now, it's black token's turn.");
                WhiteToken1.setLayoutX(518);
                WhiteToken1.setLayoutY(317);

            }

            if(PageCount == 3){
                BlackToken1.setLayoutX(516);
                BlackToken1.setLayoutY(463);
                InstructionText.setText("Once a black token is placed. Back to White Token turn.");

            }

            if(PageCount == 4){
                Circle.setVisible(true);
                WhiteToken4.setLayoutX(226);
                WhiteToken4.setLayoutY(317);
                WhiteToken2.setLayoutX(372);
                WhiteToken2.setLayoutY(317);
                BlackToken2.setLayoutX(619);
                BlackToken2.setLayoutY(714);
                Circle.setLayoutX(371);
                Circle.setLayoutY(317);
                InstructionText.setText("When a player is about to place a token on a position where it forms three tokens on a line. It's Mill condition.");

            }

            if(PageCount == 5){
                Circle2.setVisible(true);
                Circle.setLayoutX(516);
                Circle.setLayoutY(460);
                Circle2.setLayoutX(619);
                Circle2.setLayoutY(707);
                BlackToken2.setVisible(true);
                InstructionText.setText("You can choose to remove one of your opponent's token on the board.");

            }

            if(PageCount == 6){
                Circle.setVisible(false);
                Circle2.setVisible(false);
                BlackToken2.setVisible(false);
                InstructionText.setText("Once removed, the token will not return back to token pool. It can never be used again.");

            }

            if(PageCount == 7){
                BlackToken2.setVisible(false);
                BlackToken3.setLayoutX(619);
                BlackToken3.setLayoutY(460);
                BlackToken6.setLayoutX(721);
                BlackToken6.setLayoutY(460);
                WhiteToken3.setLayoutX(721);
                WhiteToken3.setLayoutX(118);
                Cross1.setVisible(true);
                Cross2.setVisible(true);
                InstructionText.setText("When Mill happens, you can not remove opponent's token that's in a Mill.");
                ChapterCount++;
                PageCount=0;

            }


        }

        if(ChapterCount ==2){

            if(PageCount==1){
                TitleMessage.setText("2.Slide Token");
                Circle.setVisible(false);
                Circle2.setVisible(false);
                Line.setVisible(false);
                Cross1.setVisible(false);
                Cross2.setVisible(false);
                WhiteToken1.setLayoutX(123);
                WhiteToken1.setLayoutY(217);
                WhiteToken2.setLayoutX(370);
                WhiteToken2.setLayoutY(118);
                WhiteToken3.setLayoutX(226);
                WhiteToken3.setLayoutY(463);
                WhiteToken4.setLayoutX(22);
                WhiteToken4.setLayoutY(118);
                WhiteToken5.setLayoutX(370);
                WhiteToken5.setLayoutY(812);
                WhiteToken6.setLayoutX(519);
                WhiteToken6.setLayoutY(614);
                WhiteToken7.setLayoutX(124);
                WhiteToken7.setLayoutY(464);
                WhiteToken8.setLayoutX(621);
                WhiteToken8.setLayoutY(713);
                WhiteToken9.setLayoutX(518);
                WhiteToken9.setLayoutY(317);

                BlackToken1.setLayoutX(370);
                BlackToken1.setLayoutY(217);
                BlackToken2.setLayoutX(722);
                BlackToken2.setLayoutY(118);
                BlackToken3.setLayoutX(23);
                BlackToken3.setLayoutY(460);
                BlackToken4.setLayoutX(122);
                BlackToken4.setLayoutY(713);
                BlackToken5.setLayoutX(370);
                BlackToken5.setLayoutY(713);
                BlackToken6.setLayoutX(373);
                BlackToken6.setLayoutY(614);
                BlackToken7.setLayoutX(225);
                BlackToken7.setLayoutY(614);
                BlackToken8.setLayoutX(518);
                BlackToken8.setLayoutY(463);
                BlackToken9.setLayoutX(225);
                BlackToken9.setLayoutY(317);

                InstructionText.setText("When Tokens are fully placed on the board. You can only slide the tokens.");
            }

            if(PageCount==2){

                Circle2.setVisible(true);
                Circle2.setLayoutX(619);
                Circle2.setLayoutY(707);
                InstructionText.setText("You need to choose a token that you want to move.");
            }

            if(PageCount==3){

                Circle2.setVisible(true);
                Circle2.setLayoutX(619);
                Circle2.setLayoutY(463);
                InstructionText.setText("You can only move it to the available positions next to it.");
            }

            if(PageCount==4){

                Circle2.setVisible(false);
                WhiteToken8.setLayoutX(619);
                WhiteToken8.setLayoutY(463);
                InstructionText.setText("Good Job! You have learnt how to slide the token.");
            }

            if(PageCount==5){
                Line.setVisible(true);
                Circle2.setVisible(true);
                Line.setLayoutX(582);
                Line.setLayoutY(259);
                Line.setStartX(-460);
                Line.setStartY(455);
                Line.setEndX(39);
                Line.setEndY(454);
                BlackToken6.setLayoutX(621);
                BlackToken6.setLayoutY(713);
                Circle2.setLayoutX(122);
                Circle2.setLayoutY(217);
                InstructionText.setText("When a Mill happens while sliding the token. Same rules as before, you can remove one opponent's token");
            }

            if(PageCount==6){

                Circle2.setVisible(false);
                Line.setVisible(false);
                WhiteToken1.setVisible(false);
                InstructionText.setText("The removed token can not be placed back on board again.");
                PageCount=0;
                ChapterCount++;
            }

        }


        if(ChapterCount ==3){
            if(PageCount==1){
                TitleMessage.setText("3.Jump Token");
                Line.setVisible(false);

                Circle2.setVisible(true);
                Circle2.setLayoutX(518);
                Circle2.setLayoutY(614);

                WhiteToken1.setVisible(true);
                WhiteToken1.setLayoutX(122);
                WhiteToken1.setLayoutY(217);

                WhiteToken2.setVisible(true);
                WhiteToken2.setLayoutX(373);
                WhiteToken2.setLayoutY(217);

                WhiteToken3.setVisible(true);
                WhiteToken3.setLayoutX(619);
                WhiteToken3.setLayoutY(214);

                WhiteToken4.setVisible(true);
                WhiteToken4.setLayoutX(516);
                WhiteToken4.setLayoutY(317);
                WhiteToken5.setVisible(false);
                WhiteToken6.setVisible(false);
                WhiteToken7.setVisible(false);
                WhiteToken8.setVisible(false);
                WhiteToken9.setVisible(false);


                BlackToken1.setVisible(true);
                BlackToken1.setLayoutX(519);
                BlackToken1.setLayoutY(614);

                BlackToken2.setVisible(true);
                BlackToken2.setLayoutX(124);
                BlackToken2.setLayoutY(713);

                BlackToken3.setVisible(true);
                BlackToken3.setLayoutX(721);
                BlackToken3.setLayoutY(812);
                BlackToken4.setVisible(false);
                BlackToken5.setVisible(false);
                BlackToken6.setVisible(false);
                BlackToken7.setVisible(false);
                BlackToken8.setVisible(false);
                BlackToken9.setVisible(false);

                InstructionText.setText("When one player only has three tokens left. They can jump tokens to any available positions on the board");



            }

            if(PageCount==2){
                Circle2.setVisible(false);

                BlackToken1.setLayoutX(370);
                BlackToken1.setLayoutY(713);
                InstructionText.setText("Well done. You have learnt how to jump the token.");
            }

            if(PageCount==3){

                BlackToken1.setLayoutX(370);
                BlackToken1.setLayoutY(713);
                BlackToken3.setLayoutX(619);
                BlackToken3.setLayoutY(713);
                InstructionText.setText("When a Mill is formed while jumping the token. You can also remove one available token of your opponent.");
                Line.setVisible(true);
                Circle2.setVisible(true);
                Line.setLayoutX(582);
                Line.setLayoutY(259);
                Line.setStartX(-460);
                Line.setStartY(455);
                Line.setEndX(39);
                Line.setEndY(454);
                Circle2.setLayoutX(516);
                Circle2.setLayoutY(317);

            }

            if(PageCount==4){

                Circle2.setVisible(false);
                WhiteToken4.setVisible(false);
                InstructionText.setText("Just like this.");
                PageCount=0;
                ChapterCount++;
            }


        }

        if(ChapterCount==4){
            if(PageCount==1){
                TitleMessage.setText("4. Winning Condition");
                WhiteToken1.setLayoutX(122);
                WhiteToken1.setLayoutY(217);
                WhiteToken2.setLayoutX(373);
                WhiteToken2.setLayoutY(217);
                WhiteToken3.setLayoutX(619);
                WhiteToken3.setLayoutY(214);
                WhiteToken4.setVisible(false);
                WhiteToken5.setVisible(false);
                WhiteToken6.setVisible(false);
                WhiteToken7.setVisible(false);
                WhiteToken8.setVisible(false);
                WhiteToken9.setVisible(false);



                BlackToken1.setVisible(false);
                BlackToken2.setLayoutX(124);
                BlackToken2.setLayoutY(713);
                BlackToken3.setLayoutX(621);
                BlackToken3.setLayoutY(713);
                BlackToken4.setVisible(false);
                BlackToken5.setVisible(false);
                BlackToken6.setVisible(false);
                BlackToken7.setVisible(false);
                BlackToken8.setVisible(false);
                BlackToken9.setVisible(false);
                Line.setVisible(false);
                Circle2.setVisible(false);
                InstructionText.setText("Winning Condition 1: If one player only has two tokens left on the board. The player loses the game.");
            }

            if(PageCount==2){

                WhiteToken1.setLayoutX(23);
                WhiteToken1.setLayoutY(118);
                WhiteToken2.setLayoutX(121);
                WhiteToken2.setLayoutY(217);
                WhiteToken3.setLayoutX(619);
                WhiteToken3.setLayoutY(212);
                WhiteToken4.setLayoutX(372);
                WhiteToken4.setLayoutY(316);
                WhiteToken5.setLayoutX(721);
                WhiteToken5.setLayoutY(460);
                WhiteToken4.setVisible(true);
                WhiteToken5.setVisible(true);

                BlackToken1.setVisible(true);
                BlackToken1.setLayoutX(371);
                BlackToken1.setLayoutY(118);
                BlackToken2.setLayoutX(721);
                BlackToken2.setLayoutY(118);
                BlackToken3.setLayoutX(370);
                BlackToken3.setLayoutY(217);

                InstructionText.setText("Winning Condition 2: If a player does not have legal moves. The player loses the game. In this case Black loses.");

            }

            if(PageCount==3){
                InstructionText.setText("That's the end of the tutorial. You may press the Play button to start the game now!!");
                InstructionText.setTextFill(Color.RED);
            }


        }


    }

    private void setupNextButton(Button button){
        button.setOnMouseClicked(mouseEvent -> {
            System.out.println("NextButtonPressed");

            PageCount++;

            checkScene();

        });
    }

    private void setupPreviousButton(Button button){
        button.setOnMouseClicked(mouseEvent -> {
            System.out.println("PreviousButtonPressed");

            CurrentPage= PageCount-1;
            for(int i=1; i<=CurrentPage; i++){
                PageCount = i;
                System.out.println(PageCount);
                checkScene();
            }
        });
    }


    private void setupNextChapterButton(Shape shape){
        shape.setOnMouseClicked(mouseEvent -> {
            System.out.println("NextChapterButtonPressed");

            ChapterCount++;
            PageCount=1;
            checkScene();


        });
    }

    private void setupPreviousChapterButton(Shape shape){
        shape.setOnMouseClicked(mouseEvent -> {
            System.out.println("PreviousChapterButtonPressed");

            CurrentChapter=ChapterCount-1;
            for(int i=1; i<=CurrentChapter; i++){
                ChapterCount = i;
                System.out.println(ChapterCount);
                PageCount=1;
                checkScene();
            }

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
