package snakefx_game.view.player;

import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import snakefx_game.player.Body;
import snakefx_game.player.Head;

/**
 *
 * @author RoughTomato
 */
public class SnakeRactangles {
    private ArrayList<SnakeRectangle> bodyParts;
    private Pane gameSurface;

    public SnakeRactangles(int count, Pane gameSurface){
        this.gameSurface = gameSurface;
        this.bodyParts = new ArrayList<>();
        for(int bodyPartsCount = 0; bodyPartsCount < count; bodyPartsCount++) {
            generateSnakeBody(bodyPartsCount);
        }
        for(int i = 0; i < count; i++){
            this.gameSurface.getChildren().add(
                    this.bodyParts.get(i).getRect());
        }
    }
    
    public void iterateSnakeBody(double newHeadX, double newHeadY){
        this.bodyParts.get(0).moveBodyPart(newHeadX, newHeadY);
        for(int i = 1; i < bodyParts.size(); i++){
            this.bodyParts.get(i).moveBodyPart(
                    this.bodyParts.get(i-1).getBodyOldX(),
                    this.bodyParts.get(i-1).getBodyOldY()
            );
        }
    }
    
    public double getSnakeHeadX(){
        return this.bodyParts.get(0).getBodyPartX();
    }
    
    public double getSnakeHeadY(){
        return this.bodyParts.get(0).getBodyPartY();
    }
    
    public void clearSnakeBody(){
        bodyParts.forEach((sr) -> {
            gameSurface.getChildren().remove(sr.getRect());
        });
        bodyParts.clear();
    }
    
    public SnakeRectangle getSnakeRectangle(int index){
        return bodyParts.get(index);
    }
    
    private void generateSnakeBody(int index) {
        if(index == 0) {
            this.bodyParts.add(new SnakeRectangle(new Head(300,300),
                    Color.CORNFLOWERBLUE
            ));
        }
        else if((index % 10) == 0) {
            this.bodyParts.add(new SnakeRectangle(new Body(300,(300 + (index * 10))),
                    Color.DARKOLIVEGREEN
            ));
        }
        else {
            this.bodyParts.add(new SnakeRectangle(new Body(300,(300 + (index * 10))),
            Color.GRAY));
        }
        
    }
}
