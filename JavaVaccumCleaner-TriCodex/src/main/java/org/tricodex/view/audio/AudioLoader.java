package org.tricodex.view.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AudioLoader {
    private List<URL> audioList = new ArrayList<>();

    public AudioLoader() {
        loadAudio();
    }

    private void loadAudio() {
        audioList.add(getClass().getResource("/audio/cat_meow_1.wav"));
        audioList.add(getClass().getResource("/audio/cat_meow_2.wav"));
        audioList.add(getClass().getResource("/audio/cat_meow_3.wav"));
        audioList.add(getClass().getResource("/audio/power_up_1.wav"));
        audioList.add(getClass().getResource("/audio/power_up_2.wav"));
        audioList.add(getClass().getResource("/audio/vacuum_cleaner.wav"));
        audioList.add(getClass().getResource("/audio/music.wav"));
    }

    public AudioInputStream getAudioStream(int index) {
        try {
            return AudioSystem.getAudioInputStream(audioList.get(index));
        } catch (Exception e) {
            // Handle exception here
        }
        return null;
    }
}
