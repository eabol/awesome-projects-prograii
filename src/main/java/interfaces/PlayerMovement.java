package interfaces;

import enumerators.Directions;

public interface PlayerMovement {
    public void setDefaultValue();

    public void updatePlayerSpeed();

    public Directions getDirection();

}
