package main;

public abstract class SmackableCharacter {
    private String name;
    private String avatar;
    private boolean beaten;

    public SmackableCharacter() {
        this.name = "Esbirro";
        this.avatar = "\'\'";
        this.beaten = false;
    }

    public SmackableCharacter(String name) {
        this.name = name;
        this.avatar = "\'\'";
        this.beaten = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isBeaten() {
        return beaten;
    }

    public void setBeaten(boolean beaten) {
        this.beaten = beaten;
    }
}
