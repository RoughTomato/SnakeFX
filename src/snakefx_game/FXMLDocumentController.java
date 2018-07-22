package snakefx_game;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import snakefx_game.player.Player;
import snakefx_game.view.player.SnakeRactangles;

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
    private Player player;
    private AnimationTimer timer;
    private final int CHAR_LIMIT = 18;
    
    public boolean up = true;
    public boolean down = false;
    public boolean left = false;
    public boolean right = false;
    
    @FXML
    void onRestartPressed(ActionEvent event) {
        timer.stop();
        timer = null;
        this.player.setScore(0);
        this.score.setText(this.player.getScoreToString());
        this.player.setName("");
        this.snake.clearSnakeBody();
        this.restartStates();
        nameField.setText(this.player.getName());
        nameField.setPromptText("Name");
        nameField.setVisible(true);
        startButton.setVisible(true);
    }
    
    @FXML
    void onStartPressed(ActionEvent event) {
        nameField.setVisible(false);
        startButton.setVisible(false);
        player = new Player(nameField.getText());
        scene = gameBoard.getScene();
        snake = new SnakeRactangles(5,gameBoard);
        gameBoardListners();
        game();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        limitCharacters();
    } 
    
    private void limitCharacters() {
        nameField.lengthProperty().addListener((ObservableValue<? extends Number>
                observable, Number oldValue, Number newValue) -> {
            if (newValue.intValue() > oldValue.intValue()) {
                if (nameField.getText().length() >= CHAR_LIMIT) {
                    nameField.setText(nameField.getText().substring(0,CHAR_LIMIT));
                }
            }
        });
    }
    
    private void game() {
        
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                double dx = 0;
                double dy = 0;
                if(up)
                    dy -= 10;
                if(down)
                    dy += 10;
                if(right)
                    dx += 10;
                if(left)
                    dx -= 10;
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
    
    private void gameBoardListners(){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case W:
                        if(down != true) {
                            up = true;
                            down = false;
                            left = false;
                            right = false;
                        }
                    break;
                    case S:
                        if(up != true) {
                            up = false;
                            down = true;
                            left = false;
                            right = false;
                        }
                    break;
                    case A:
                        if(right != true) {
                            left  = true;
                            up    = false;
                            down  = false;
                            right = false;
                        }
                    break;
                    case D:
                        if(left != true) {
                            left  = false;
                            up    = false;
                            down  = false;
                            right = true;
                        }
                    break;
                }
            }
        });

    }

    private void restartStates() {
        up = true;
        left = false;
        down = false;
        right = false;
    }
}
