package org.tricodex.view.panels;

import org.tricodex.model.UserGuide;
import org.tricodex.model.Vacuum;
import org.tricodex.utils.abstracts.Panel;
import org.tricodex.utils.enums.MoveDirection;
import org.tricodex.view.services.AudioService;
import org.tricodex.view.handlers.KeyHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

public class ControlPanel extends Panel {
    private final Map<BooleanSupplier, Runnable> keyMapping;
    private AudioService audioService;

    public ControlPanel(UserGuide userGuide, KeyHandler keyHandler, Vacuum vacuum) {
        keyMapping = new HashMap<>() {{
            put(keyHandler::isUpPressed, () -> {
                userGuide.guideVacuum(MoveDirection.UP);
                audioService.playVacuumSound();
            });
            put(keyHandler::isDownPressed, () -> {
                userGuide.guideVacuum(MoveDirection.DOWN);
                audioService.playVacuumSound();
            });
            put(keyHandler::isLeftPressed, () -> {
                userGuide.guideVacuum(MoveDirection.LEFT);
                audioService.playVacuumSound();
            });
            put(keyHandler::isRightPressed, () -> {
                userGuide.guideVacuum(MoveDirection.RIGHT);
                audioService.playVacuumSound();
            });
            put(keyHandler::isCleaningPressed, () -> {
                vacuum.clean();
                audioService.playVacuumSound();
            });
            put(keyHandler::isRechargingPressed, vacuum::recharge);
            put(keyHandler::isEmptyingPressed, vacuum::emptyBag);
        }};
    }

    public void actionPerformed() {
        keyMapping.forEach((keyPress, action) -> {
            if (keyPress.getAsBoolean()) {
                action.run();
            }
        });
    }

    public void setVacuumSound(AudioService audioService) {
        this.audioService = audioService;
    }
}
