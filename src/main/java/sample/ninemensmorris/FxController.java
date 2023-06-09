package sample.ninemensmorris;
import java.io.IOException;
import java.util.HashMap;


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

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class FxController implements Initializable {

    @FXML
    private Label ErrorMessage;

    @FXML
    private Label TurnMessage;


    @FXML
    private Label MillText;

    @FXML
    private Text player1Text;

    @FXML
    private Text player2Text;

    @FXML
    private Shape MillButton;

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
    private Button HintButton;

    @FXML
    private Button QuitButton;



    private Game game;
    //more tokens to be added here

    ArrayList<Shape> buttons;
    ArrayList<Shape> tokens;



    private static final int NUM_POSITION = 24;
    private static final int NUM_TOKEN = 9;

    private int playerTurn =0;

    private int LayoutX;
    private int LayoutY;

    private Shape currentToken =null;


    private HashMap<Shape, HasShape> instanceToShapeMap = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        buttons =new ArrayList<>(Arrays.asList(button1,button2, button3, button4, button5, button6, button7, button8, button9, button10
        , button11, button12, button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24,MillButton));

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

        // set up hint button
        setupHintButton(HintButton);

        // initialise a new game
        game = new Game();

        // get positions
        Position[] positions = game.getBoard().getPositions();
        Token[] whiteTokens = game.getBoard().getWhiteTokens();
        Token[] blackTokens = game.getBoard().getBlackTokens();


        // create positions
        for (int i=0; i < 24; i++)
        {
            //create a new position
            positions[i].setShape(buttons.get(i));
            instanceToShapeMap.put(buttons.get(i), positions[i]);
        }

        // create white tokens
        for (int i=0; i < 9; i++)
        {
            //create a new token
            whiteTokens[i].setShape(tokens.get(i));
            instanceToShapeMap.put(tokens.get(i), whiteTokens[i]);
        }

        // create black tokens
        for (int i = 9; i < 18; i++)
        {
            //create a new token
            blackTokens[i-9].setShape(tokens.get(i));
            instanceToShapeMap.put(tokens.get(i), blackTokens[i-9]);
        }




        //hide Mill text
        MillText.setVisible(false);

        //hide Mill Button
        MillButton.setVisible(false);

        //hide Error Message
        ErrorMessage.setVisible(false);


        //Update Player name
        if (data.getPlayerName1().length() >= 10 || data.getPlayerName1().length() >= 10)
        {
            data.setUserName1("Name is too long");
            return;
        }

        player1Text.setText(data.getPlayerName1());
        player2Text.setText(data.getPlayerName2());


    }
    private void setupPosition(Shape shape) {
        // set on-click event
        shape.setOnMouseClicked(mouseEvent -> {
            LayoutX = (int) shape.getLayoutX();
            LayoutY = (int) shape.getLayoutY();
            if(currentToken ==null){

                System.out.println("no token");
                ErrorMessage.setVisible(true);
                ErrorMessage.setText("Please select token first");


            } else {
                // get the token
                Token token = (Token) instanceToShapeMap.get(currentToken);

                //
                if (game.isHasMill())
                {
                    int a= 1;
                }
                if (game.isHasMill() && shape != MillButton)
                {
                    // TODO: printing to console works, but it does  not display as error message
                    System.out.println("Must make a mill move!");
                    ErrorMessage.setVisible(true);
                    ErrorMessage.setText("Must make a mill move");
                    return;
                }

                // get destination
                Position destination;
                if (shape == MillButton)
                {
                    destination = null;
                }
                else
                {
                    destination = (Position) instanceToShapeMap.get(shape);
                }

                // tell game to execute move
                String errorMessage = game.executeMove(token, destination, MillText, MillButton);

                if (errorMessage != null)
                {
                    // TODO: printing to console works, but it does  not display as error message
                    System.out.println(errorMessage);
                    ErrorMessage.setVisible(true);
                    ErrorMessage.setText(errorMessage);
                }

                TurnMessage.setText(game.getDisplayTurn());

                currentToken = null;
//
//                displayMoveToken(currentToken, LayoutX, LayoutY);


            }

            shape.setDisable(false);
//            ErrorMessage.setVisible(false);
            //checkIfGameIsOver();
        });

    }

    public void setupQuitButton(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("WelcomeUI.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }



    private void setupToken(Shape shape) {
        shape.setOnMouseClicked(mouseEvent -> {

            ErrorMessage.setVisible(false);
            currentToken = shape;
            shape.setDisable(false);
            //checkIfGameIsOver();
        });

    }

    private void setupHintButton(Button button){
        button.setOnMouseClicked(mouseEvent -> {
            System.out.println("hintButtonPressed");

            game.resetShapeColour();

            if (currentToken == null)
            {
                game.displayPlayableToken();
            }
            else
            {
                if (!game.isHasMill())
                {
                    game.getDisplay().glowUpShape(currentToken);
                }
                Token token = (Token) instanceToShapeMap.get(currentToken);
                game.displayPlaceablePosition(token);
            }
            currentToken = null;
        });
    }












}