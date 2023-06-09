package org.tricodex.view.panels;

import org.tricodex.model.UserGuide;
import org.tricodex.model.Vacuum;
import org.tricodex.utils.abstracts.Panel;
import org.tricodex.utils.enums.MoveDirection;
import org.tricodex.view.audio.AudioPlayer;
import org.tricodex.view.handlers.KeyHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

public class ControlPanel extends Panel {
    private final Map<BooleanSupplier, Runnable> keyMapping;
    private AudioPlayer vacuumSound;
    private boolean isVacuumCleaning;

    public ControlPanel(UserGuide userGuide, KeyHandler keyHandler, Vacuum vacuum) {
        keyMapping = new HashMap<>() {{
            put(keyHandler::isUpPressed, () -> {
                userGuide.guideVacuum(MoveDirection.UP);
                playVacuumSound();
            });
            put(keyHandler::isDownPressed, () -> {
                userGuide.guideVacuum(MoveDirection.DOWN);
                playVacuumSound();
            });
            put(keyHandler::isLeftPressed, () -> {
                userGuide.guideVacuum(MoveDirection.LEFT);
                playVacuumSound();
            });
            put(keyHandler::isRightPressed, () -> {
                userGuide.guideVacuum(MoveDirection.RIGHT);
                playVacuumSound();
            });
            put(keyHandler::isCleaningPressed, () -> {
                vacuum.clean();
                isVacuumCleaning = true;
                playVacuumSound();
            });
            put(keyHandler::isRechargingPressed, () -> {
                vacuum.recharge();
                stopVacuumSound();
                isVacuumCleaning = false;
            });
            put(keyHandler::isEmptyingPressed, () -> {
                vacuum.emptyBag();
                stopVacuumSound();
                isVacuumCleaning = false;
            });
        }};
    }

    public void actionPerformed() {
        keyMapping.forEach((keyPress, action) -> {
            if (keyPress.getAsBoolean()) {
                action.run();
            }
        });
    }

    public void setVacuumSound(AudioPlayer vacuumSound) {
        this.vacuumSound = vacuumSound;
    }

    private void playVacuumSound() {
        if (!vacuumSound.isPlaying() && isVacuumCleaning) {
            vacuumSound.play();
        }
    }

    private void stopVacuumSound() {
        if (vacuumSound.isPlaying()) {
            vacuumSound.stop();
        }
    }
}
