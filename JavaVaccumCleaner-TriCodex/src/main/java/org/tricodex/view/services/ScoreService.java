package org.tricodex.view.services;

public class ScoreService {
    private int gameScore = 0;
    private int highScore = 0;

    public void addScore(int score) {
        gameScore += score;
        checkAndUpdateHighScore();
    }

    public int getGameScore() {
        return gameScore;
    }

    public int getHighScore() {
        return highScore;
    }

    private void checkAndUpdateHighScore() {
        if(gameScore > highScore) {
            highScore = gameScore;
        }
    }

    public void resetScore() {
        gameScore = 0;
    }
}
