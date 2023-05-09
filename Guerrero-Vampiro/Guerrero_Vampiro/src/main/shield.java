package main;

public class shield extends Equipment{
    public shield(String name, int cuantity) {
        super(name, cuantity);
    }
    public boolean activateShield() {
        return true;
    }
    public boolean deactivateShield() {
        return false;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCuantity(int cuantity) {
        this.cuantity = cuantity;
    }
    public String getName() {
        return this.name;
    }
    public double getCuantity() {
        return this.cuantity;
    }

    public void shieldUp(warrior character) {
        character.setShieldActive(true);
    }
    public void shieldDown(warrior character) {
        character.setShieldActive(false);
    }
}
