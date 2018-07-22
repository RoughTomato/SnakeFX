package snakefx_game.player;

/**
 *
 * @author RoughTomato
 */
public class Player {

    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }

    public void setScore(int score){
        if(score > 0){
            this.score = score;
        }
    }

    public String getScoreToString(){
        return Integer.toString(score);
    }

}
