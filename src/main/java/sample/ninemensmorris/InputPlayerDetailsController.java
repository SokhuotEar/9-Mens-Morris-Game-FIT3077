package sample.ninemensmorris;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class InputPlayerDetailsController {

    @FXML
    private TextField player1;

    @FXML
    private TextField player2;

    PlayerNameHolder data = PlayerNameHolder.getInstance();
    public void switchToGameScene(ActionEvent event) throws IOException {
        data.setUserName1(player1.getText());
        data.setUserName2(player2.getText());
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }



};

