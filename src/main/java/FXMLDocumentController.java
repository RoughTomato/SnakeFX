package main.java;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import main.java.listeners.KeyPressedListener;
import main.java.player.PlayerPOJO;
import main.java.view.player.SnakeRactangles;

/**
 *
 * @author RoughTomato
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Pane gameBoard;

    @FXML
    private Button startButton;

    @FXML
    private TextField nameField;

    @FXML
    private Label score;

    @FXML
    private Label hiScore;

    @FXML
    private Button restartButton;

    private Scene scene;
    private SnakeRactangles snake;
    private PlayerPOJO player;
    private AnimationTimer timer;
    private final int CHAR_LIMIT = 18;
    private KeyPressedListener keyListener;
    
    @FXML
    void onRestartPressed(ActionEvent event) {

    }
    
    @FXML
    void onStartPressed(ActionEvent event) {


    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    } 
    

}
