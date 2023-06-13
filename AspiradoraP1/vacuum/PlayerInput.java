package vacuum;

import java.util.Scanner;


    public abstract class PlayerInput {

        public static char takePlayerInput() {
            Scanner input = new Scanner(System.in);
            return input.nextLine().charAt(0);
        }
    }

