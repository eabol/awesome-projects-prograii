package main;
import org.junit.jupiter.api.Test;
public abstract class Weapons {
    private double damage;
    private double accuracy;

    public Weapons(double damage, double accuracy) {
        this.damage = damage;
        this.accuracy = accuracy;
    }
    public Weapons() {
    }

    @Test
    public double getDamage() {
            return damage;
        }

        @Test
    public void setDamage(int damage) {
            this.damage = damage;
        }

        @Test
    public double getAccuracy() {
            return accuracy;
        }

        @Test
    public void setAccuracy(double accuracy) {
            this.accuracy = accuracy;
        }
}
