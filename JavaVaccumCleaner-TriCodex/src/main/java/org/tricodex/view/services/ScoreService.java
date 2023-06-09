package org.tricodex.view.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ScoreService {
    private static final String HIGH_SCORE_FILE = "highscore.properties";
    private static final String HIGH_SCORE_KEY = "highscore";

    private int gameScore = 0;
    private int highScore = 0;

    public ScoreService() {
        loadHighScore();
    }

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

    private void loadHighScore() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(HIGH_SCORE_FILE));
            highScore = Integer.parseInt(properties.getProperty(HIGH_SCORE_KEY, "0"));
        } catch (IOException e) {
            highScore = 0;
        }
    }

    private void saveHighScore() {
        Properties properties = new Properties();
        properties.setProperty(HIGH_SCORE_KEY, String.valueOf(highScore));
        try {
            properties.store(new FileOutputStream(HIGH_SCORE_FILE), null);
        } catch (IOException e) {
            // Handle exception here
            e.printStackTrace();
        }
    }

    private void checkAndUpdateHighScore() {
        if(gameScore > highScore) {
            highScore = gameScore;
            saveHighScore();
        }
    }

    public void resetScore() {
        gameScore = 0;
    }
}
