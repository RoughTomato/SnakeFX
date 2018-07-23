package snakefx_game.listeners;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author RoughTomato
 */
public class KeyPressedListener {
    public enum Directions {UP, DOWN, LEFT, RIGHT}

    private Scene scene;
    private Directions direction;

    public KeyPressedListener(Scene scene) {
        this.scene = scene;
        gameBoardListeners();
        this.direction = Directions.UP;
    }
    
    public Directions getDirection() {
        return direction;
    }
    
    private void moveUp() {
        if(direction != Directions.DOWN) {
            direction = Directions.UP;
        }
    }
    
    private void moveDown() {
        if(direction != Directions.UP) {
            direction = Directions.DOWN;
        }
    }
    
    private void moveLeft() {
        if(direction != Directions.RIGHT) {
            direction = Directions.LEFT;
        }
    }
    
    private void moveRight() {
        if(direction != Directions.LEFT) {
            direction = Directions.RIGHT;
        }
    }

    private void gameBoardListeners(){
    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case W:
                        moveUp();
                    break;
                    case S:
                        moveDown();
                    break;
                    case A:
                        moveLeft();
                    break;
                    case D:
                        moveRight();
                    break;
                }
            }
        });
    }
}
