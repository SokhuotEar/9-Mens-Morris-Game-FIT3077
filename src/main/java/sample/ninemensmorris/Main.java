package sample.ninemensmorris;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/** Main Driver Class
 */
public class Main extends Application {

    /**
     * Game Instance
     */
    private Game game;

    /**
     * Tutorial Game Instance
     */

    private TutorialGame tutorialGame;


    /**
     * Boolean to check if app is still running
     */
    private Boolean appRunning;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 1000);
        stage.setTitle("Welcome to Nine Men's Morris!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}