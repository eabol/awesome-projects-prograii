import java.util.Scanner;
    public class ControllerD {
        private VacuumCleanerD vacuumCleanerD;
        private BoardD boardD;
        private Scanner scanner;

        public ControllerD() {
            boardD = new BoardD(25, 10);
            boardD.generateMap();
            vacuumCleanerD = new VacuumCleanerD(8, 1, 1,0,100,100);
            scanner = new Scanner(System.in);
        }

        public void run() {
            boolean running = true;

            System.out.println("¡Welcome to the Vacuum Cleaner Game!");

            while (running) {
                System.out.println("========================================");
                boardD.printMap();
                System.out.println("----------------------------------------");
                System.out.println("Current Steps: " + vacuumCleanerD.getSteps());
                System.out.println("Remaining Dirt: " + boardD.getTotalDirt());
                System.out.println("Remaining Battery: " + vacuumCleanerD.getBattery());
                System.out.println("Bag Capacity: " + vacuumCleanerD.getBag());
                System.out.println("Actual Dirt in Bag: " + vacuumCleanerD.getVacuumedDirt());
                System.out.println("----------------------------------------");
                System.out.println("Choose an option please:");
                System.out.println("1. Move the vacuum cleaner");
                System.out.println("2. Empty the trash");
                System.out.println("3. Exit the game");
                //seria mejor poner una cuarta opcion que sea cambiar al modo manual en el que lo podamos mover a la aspiradora o que se haga ed otro modo

                int option = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea después de leer el entero

                switch (option) {
                    case 1:
                        moveVacuumCleaner();
                        break;
                    case 2:
                        emptyTrash();
                        break;
                    case 3:
                        running = false;
                        break;
                    default:
                        System.out.println("Not Valid Option,please choose one of the options above");
                        break;
                }
            }

            System.out.println("¡Thanks for playing!");
        }

        private void moveVacuumCleaner() {
            if (vacuumCleanerD.getBattery() <= 0) {
                System.out.println("Battery is over, you can't move the vacuum cleaner anymore.");
                return;
            }

            System.out.println("Choose an option to move the Vacuum Cleaner:");
            System.out.println("1. Up");
            System.out.println("2. Down");
            System.out.println("3. Left");
            System.out.println("4. Right");
            System.out.println("5. Up-left");
            System.out.println("6. Up-right");
            System.out.println("7. Down-left");
            System.out.println("8. Down-right");

            int direction = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de leer el entero

            if (vacuumCleanerD.move(boardD)){
                vacuumCleanerD.cleanTile(boardD);
                vacuumCleanerD.decreaseBattery();
            } else {
                System.out.println("Movement not valid.You can't move the vacuum cleaner to that direction.");
            }
        }

        private void emptyTrash() {
            if (vacuumCleanerD.getVacuumedDirt() <= 0) {
                System.out.println("The bag is empty");
            } else {
                vacuumCleanerD.emptyTrash();
                System.out.println("The bag has been emptied correctly.");
            }
        }
    }

}
