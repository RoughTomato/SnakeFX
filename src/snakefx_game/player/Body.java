package snakefx_game.player;

/**
 *
 * @author RoughTomato
 */
public class Body implements Snake{
    double bodyX;
    double bodyY;
    double oldX;
    double oldY;
    
    public Body(double x, double y){
        this.bodyX = x;
        this.bodyY = y;
    }
    
    @Override
    public void setX(double x) {
        this.oldX = this.bodyX;
        this.bodyX = x;
    }

    @Override
    public void setY(double y) {
        this.oldY = this.bodyY;
        this.bodyY = y;
    }

    @Override
    public double getX() {
        return this.bodyX;
    }

    @Override
    public double getY() {
        return this.bodyY;
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
