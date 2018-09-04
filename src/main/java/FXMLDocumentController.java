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
import main.java.view.game.GameLoop;
import main.java.view.game.GameLoopBuilder;
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

    private GameLoop gameLoop;
    
    @FXML
    void onRestartPressed(ActionEvent event) {
        gameLoop.restartPressed(event);
    }
    
    @FXML
    void onStartPressed(ActionEvent event) {
        gameLoop.startPressed(event);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GameLoopBuilder gameBuilder = new GameLoopBuilder();

        gameBuilder.havingScene(this.gameBoard.getScene())
                                    .havingGameBoard(this.gameBoard)
                                    .havingHiScore(this.hiScore)
                                    .havingScore(this.score)
                                    .havingNameField(this.nameField)
                                    .havingRestartButton(this.restartButton)
                                    .havingStartButton(this.startButton);

        gameLoop = new GameLoop(this.gameLoop);
    }

}
