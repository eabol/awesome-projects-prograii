package org.tricodex.model;

import org.tricodex.utils.enums.MoveDirection;

public class UserGuide {
    private Vacuum vacuum;

    public UserGuide(Vacuum vacuum) {
        this.vacuum = vacuum;
    }

    public void guideVacuum(MoveDirection position) {
        vacuum.move(position);
    }


}
