package main;

public class potions extends Equipment {
    warrior character = new warrior("Warrior", 100);

    public boolean berserkActive = false;
    public boolean healthActive = false;
    public boolean rockActive = false;
    public boolean eyeActive = false;
    public boolean twitterActive = false;

    public potions(String name, int cuantity) {
        super(name, cuantity);
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

}