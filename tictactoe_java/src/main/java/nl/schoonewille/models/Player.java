package nl.schoonewille.models;

public class Player {
    String name;
    int currentScore;
    int highScore;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

}
