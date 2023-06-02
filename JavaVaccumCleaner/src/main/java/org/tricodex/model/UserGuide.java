package org.tricodex.model;

import org.tricodex.utils.enums.MoveDirection;

public class UserGuide {
    private Surface surface;
    private Vaccum vaccum;

    public UserGuide(Surface surface, Vaccum vaccum) {
        this.surface = surface;
        this.vaccum = vaccum;
    }

    public void guideVaccume(MoveDirection position) {
        vaccum.move(position);
    }


}
