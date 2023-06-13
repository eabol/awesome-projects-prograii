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
        this.aspect = "0";
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

    public void setMole(SmackableCharacter character) {
        this.character = character;
    }

    public boolean isMoleInside() {
        return character != null && !character.isBeaten();
    }

    public String showMoleInside() {
        if (character != null) {
            return "Mole inside: " + character.getName();
        } else {
            return "No mole inside";
        }
    }
}

