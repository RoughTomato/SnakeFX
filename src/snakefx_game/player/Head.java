package snakefx_game.player;

/**
 *
 * @author RoughTomato
 */
public class Head implements Snake {

    private double headY;
    private double headX;
    private double oldX;
    private double oldY;

    public Head(int x, int y) {
        this.headX = x;
        this.headY = y;
    }
    
    @Override
    public void setX(double x) {
        this.oldX = this.headX;
        this.headX = x;
    }

    @Override
    public void setY(double y) {
        this.oldY = this.headY;
        this.headY = y;
    }

    @Override
    public double getX() {
        return headX;
    }

    @Override
    public double getY() {
        return headY;
    }

    @Override
    public double getOldX() {
        return this.oldX;
    }

    @Override
    public double getOldY() {
        return this.oldY;
    }
    
}
