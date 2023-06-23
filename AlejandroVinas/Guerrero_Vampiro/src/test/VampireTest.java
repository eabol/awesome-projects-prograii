package test;
import org.junit.Test;
import main.Vampire;

public class VampireTest extends Vampire {


    public VampireTest() {
        super("Dracula", 50);
    }

    @Test
    public void testVampireProperties() {
            Vampire vampire = new Vampire("Dracula", 50);
            vampire.setName("Dracula");
            vampire.setHealth(100);




            if (vampire.getName() == "Dracula") {
                System.out.println("Vampire name is Dracula");

            }
            if (vampire.getHealth() == 100) {
                System.out.println("Vampire health is 100");
            }
        }

        @Test
    public void testVampireProperties2(){

        Vampire vampire2 = new Vampire("Juan Pedro", 5);

        if (vampire2.getName() == "Dracula") {
            System.out.println("Vampire name is Dracula");
        }else {
            System.out.println("This is not Dracula is " + vampire2.getName());
        }
        if (vampire2.getHealth() == 100) {
            System.out.println("Vampire health is 100 is " + vampire2.getHealth());
        }

    }
    }


