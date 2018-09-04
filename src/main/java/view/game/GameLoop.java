package main.java.view.game;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import main.java.FXMLDocumentController;
import main.java.listeners.KeyPressedListener;
import main.java.player.PlayerPOJO;
import main.java.view.player.SnakeRactangles;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GameLoop {

    private SnakeRactangles snake;
    private PlayerPOJO player;
    private AnimationTimer timer;
    private final int CHAR_LIMIT = 18;
    private KeyPressedListener keyListener;
    private Pane gameBoard;
    private Button restartButton;
    private Button startButton;
    private Label score;
    private TextField nameField;
    private Label hiScore;
    private Scene scene;
    
    public GameLoop(){

    }

    public GameLoop(GameLoop gameLoop) {

    }

    public void StartPressed(ActionEvent event) {
        nameField.setVisible(false);
        startButton.setVisible(false);
        player = new PlayerPOJO(nameField.getText());
        scene = gameBoard.getScene();
        snake = new SnakeRactangles(5,gameBoard);
        keyListener = new KeyPressedListener(scene);
        mainGameLoop();
    }

    public void RestartPressed(ActionEvent event) {
        timer.stop();
        timer = null;
        this.player.setScore(0);
        this.score.setText(this.player.getScoreToString());
        this.player.setName("");
        this.snake.clearSnakeBody();
        nameField.setText(this.player.getName());
        nameField.setPromptText("Name");
        nameField.setVisible(true);
        startButton.setVisible(true);
    }

    private void mainGameLoop(){
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                double dx = 0;
                double dy = 0;
                switch(keyListener.getDirection()) {
                    case UP:
                        dy -= 10;
                        break;
                    case DOWN:
                        dy += 10;
                        break;
                    case RIGHT:
                        dx += 10;
                        break;
                    case LEFT:
                        dx -= 10;
                        break;
                }
                try {
                    Thread.sleep(100); //for that retro feel to it.
                } catch (InterruptedException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                //send new coordinates to head
                snake.iterateSnakeBody(
                        snake.getSnakeHeadX() + dx,
                        snake.getSnakeHeadY() + dy
                );
            }
        };
        timer.start();
    }

    private void limitCharacters() {
        nameField.lengthProperty().addListener((ObservableValue<? extends Number>
                                                        observable, Number oldValue, Number newValue) -> {
            if (newValue.intValue() > oldValue.intValue()) {
                if (nameField.getText().length() >= CHAR_LIMIT) {
                    nameField.setText(nameField.getText().substring(0, CHAR_LIMIT));
                }
            }
        });
    }
}
