package snakefx_game.view.player;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import snakefx_game.player.BodyPOJO;
/**
 *
 * @author RoughTomato
 */
public class SnakeRectangle {
    private BodyPOJO snakeBodyPart;
    private Rectangle rect;
    private Color color;

    private final int RECT_HEIGHT = 10;
    private final int RECT_WIDTH = 10;
    
    public SnakeRectangle(BodyPOJO snakeBodyPart){
        this.snakeBodyPart = snakeBodyPart;
        rect = new Rectangle(snakeBodyPart.getX(), snakeBodyPart.getY(),
                            RECT_WIDTH, RECT_HEIGHT);
    }
    
    public SnakeRectangle(BodyPOJO snakeBodyPart, Color color){
        this.snakeBodyPart = snakeBodyPart;
        rect = new Rectangle(snakeBodyPart.getX(), snakeBodyPart.getY(),
                            RECT_WIDTH, RECT_HEIGHT);
        rect.fillProperty().set(color);
    }
    
    public Rectangle getRect(){
        return rect;
    }
    
    public double getBodyOldX() {
        return this.snakeBodyPart.getOldX();
    }
    
    public double getBodyOldY() {
        return this.snakeBodyPart.getOldY();
    }
    
    public void moveBodyPart(double x, double y) {
        this.snakeBodyPart.setX(x);
        this.snakeBodyPart.setY(y);
        this.rect.setX(x);
        this.rect.setY(y);
    }

    public double getBodyPartX(){
        return snakeBodyPart.getX();
    }
    
    public double getBodyPartY(){
        return snakeBodyPart.getY();
    }
}
