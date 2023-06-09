package org.tricodex.view.services;

import org.tricodex.utils.enums.PowerUpSoundType;
import org.tricodex.view.audio.AudioLoader;
import org.tricodex.view.audio.AudioPlayer;

import java.util.Random;

public class AudioService {
    private final AudioLoader audioLoader;
    private final AudioPlayer vacuumSound;
    private final AudioPlayer powerUpSound;
    private final AudioPlayer[] catSounds;
    private int catSoundCooldown = 0;
    private static final int CAT_SOUND_COOLDOWN_MAX = 50; // Modify this to control the delay length

    public AudioService() {
        audioLoader = new AudioLoader();
        vacuumSound = new AudioPlayer();
        powerUpSound = new AudioPlayer();
        catSounds = new AudioPlayer[]{
                new AudioPlayer(),
                new AudioPlayer(),
                new AudioPlayer()
        };

        loadSounds();
    }

    private void loadSounds() {
        vacuumSound.load(audioLoader.getAudioStream(5));  // Load vacuum_cleaner.wav
        powerUpSound.load(audioLoader.getAudioStream(3)); // Load power_up_1.wav

        for (int i = 0; i < 3; i++) {
            catSounds[i].load(audioLoader.getAudioStream(i)); // Load cat_meow_1.wav, cat_meow_2.wav and cat_meow_3.wav
        }
    }

    public void playVacuumSound() {
        if (!vacuumSound.isPlaying()) {
            vacuumSound.load(audioLoader.getAudioStream(5)); // Reload the audio stream
            vacuumSound.play();
        }
    }

    public void playPowerUpSound(PowerUpSoundType powerUpSoundType) {
        int audioIndex = 3; // Default to power_up_1.wav

        if (powerUpSoundType == PowerUpSoundType.POWER_UP_COLLECTED) {
            audioIndex = 4;
        }

        if (!powerUpSound.isPlaying()) {
            powerUpSound.load(audioLoader.getAudioStream(audioIndex)); // Reload the audio stream
            powerUpSound.play();
        }
    }

    public void update() {
        if (catSoundCooldown > 0) {
            catSoundCooldown--;
        }
    }

    public void playRandomCatSound() {
        // Only play a new sound if the cooldown has reached zero
        if (catSoundCooldown == 0) {
            // Select a random cat sound
            int randomIndex = new Random().nextInt(catSounds.length);

            // Check if the selected cat sound is currently playing
            if (!catSounds[randomIndex].isPlaying()) {
                catSounds[randomIndex].load(audioLoader.getAudioStream(randomIndex)); // Reload the audio stream
                catSounds[randomIndex].play();
                catSoundCooldown = CAT_SOUND_COOLDOWN_MAX; // Reset the cooldown
            }
        }
    }
}
