package main.java.player;

/**
 *
 * @author RoughTomato
 */
public class PlayerPOJO {

    private String name;
    private int score;

    public PlayerPOJO(String name) {
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
