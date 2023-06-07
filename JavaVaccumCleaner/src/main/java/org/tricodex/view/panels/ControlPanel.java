package org.tricodex.view.panels;

import org.tricodex.model.UserGuide;
import org.tricodex.utils.abstracts.Panel;
import org.tricodex.utils.enums.MoveDirection;
import org.tricodex.view.handlers.KeyHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

public class  ControlPanel extends Panel {
    UserGuide userGuide;
    private final Map<BooleanSupplier, MoveDirection> keyMapping;

    public ControlPanel(UserGuide userGuide, KeyHandler keyHandler) {
        this.userGuide = userGuide;
        keyMapping = new HashMap<>() {{
            put(keyHandler::isUpPressed, MoveDirection.UP);
            put(keyHandler::isDownPressed, MoveDirection.DOWN);
            put(keyHandler::isLeftPressed, MoveDirection.LEFT);
            put(keyHandler::isRightPressed, MoveDirection.RIGHT);
        }};
    }

    public void actionPerformed() {
        keyMapping.forEach((keyPress, direction) -> {
            if (keyPress.getAsBoolean()) {
                userGuide.guideVaccume(direction);
            }
        });
    }

}
