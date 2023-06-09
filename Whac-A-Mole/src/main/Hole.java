package main;

import java.lang.constant.Constable;

public class Hole extends Space {
    private String aspect;
    private SmackableCharacter character;

    public Hole() {
        this.aspect = "O";
        this.character = null;
    }

    public Hole(SmackableCharacter character) {
        this.aspect = "O";
        this.character = character;
    }

    public String getAspect() {
        return aspect;
    }

    public void setAspect(String aspect) {
        this.aspect = aspect;
    }

    public SmackableCharacter getSmackableCharacter() {
        return character;
    }

    public void setSmackableCharacter(SmackableCharacter character) {
        this.character = character;
    }

    private boolean isMoleInside() {
        return this.character != null;
    }

    private String showMoleInside() {{
        return this.character.getAvatar();
    }
}
