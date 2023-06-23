package org.tricodex.view.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {
    private Clip clip;

    public void load(AudioInputStream ais) {
        try {
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            // Handle exception here
        }
    }
    public boolean isPlaying() {
        return clip.isActive();
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}