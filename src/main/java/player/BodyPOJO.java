package main.java.player;

/**
 *
 * @author RoughTomato
 */
public class BodyPOJO {
    double bodyX;
    double bodyY;
    double oldX;
    double oldY;
    
    public BodyPOJO(double x, double y){
        this.bodyX = x;
        this.bodyY = y;
    }

    public void setX(double x) {
        this.oldX = this.bodyX;
        this.bodyX = x;
    }

    public void setY(double y) {
        this.oldY = this.bodyY;
        this.bodyY = y;
    }

    public double getX() {
        return this.bodyX;
    }

    public double getY() {
        return this.bodyY;
    }

    public double getOldX() {
        return this.oldX;
    }

    public double getOldY() {
        return this.oldY;
    }
    
}
