package test;
import org.junit.Test;
import main.Vampire;

public class VampireTest extends Vampire {


    public VampireTest() {
        super("Dracula", 50, 100, 0.9);
    }

    @Test
    public void testVampireProperties() {
            Vampire vampire = new Vampire("Dracula", 50, 100, 0.9);
            vampire.setName("Dracula");
            vampire.setAttack(50);
            vampire.setHealth(100);
            vampire.setAccuracy(0.9);



            if (vampire.getName() == "Dracula") {
                System.out.println("Vampire name is Dracula");
            }
            if (vampire.getAttack() == 50) {
                System.out.println("Vampire attack is 50");
            }
            if (vampire.getHealth() == 100) {
                System.out.println("Vampire health is 100");
            }
            if (vampire.getAccuracy() == 0.9) {
                System.out.println("Vampire accuracy is 0.9");
            }
        }

        @Test
    public void testVampireProperties2(){

        Vampire vampire2 = new Vampire("Juan Pedro", 5, 10, 0.7);

        if (vampire2.getName() == "Dracula") {
            System.out.println("Vampire name is Dracula");
        }else {
            System.out.println("This is not Dracula is " + vampire2.getName());
        }
        if (vampire2.getAttack() == 50) {
            System.out.println("Vampire attack is 50");
        }else {
            System.out.println("Vampire attack is not 50 is " + vampire2.getAttack());
        }
        if (vampire2.getHealth() == 100) {
            System.out.println("Vampire health is 100 is " + vampire2.getHealth());
        }
        if (vampire2.getAccuracy() == 0.9) {
            System.out.println("Vampire accuracy is 0.9 is " + vampire2.getAccuracy());
        }

    }
    }


