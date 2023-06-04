package org.tricodex.model;

import org.tricodex.utils.enums.MoveDirection;

public class UserGuide {
    private Surface surface;
    private Vacuum vacuum;

    public UserGuide(Surface surface, Vacuum vacuum) {
        this.surface = surface;
        this.vacuum = vacuum;
    }

    public void guideVaccume(MoveDirection position) {
        vacuum.move(position);
    }


}
