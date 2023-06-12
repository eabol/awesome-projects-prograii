import java.util.Random;

    public class VacuumCleanerD {

        private int steps;
        private int id;
        private  int xCoordinate;

        private int yCoordinate;
        int bag;

        int currentBattery;

        int Battery;

        int vacuumedDirt;


        public VacuumCleanerD(int id, int xCoordinate, int yCoordinate,
                              int bag, int vacuumedDirt, int steps) {
            super();
            this.id = id;
            this.xCoordinate = xCoordinate;
            this.yCoordinate = yCoordinate;
            this.bag = bag;
            this.Battery = 100;
            this.vacuumedDirt = 0;
            this.steps=0;

            //getSteps() % 3 == 0
            //Battery = currentBattery - 1;
        }
        public int getBattery() {
            return Battery;
        }
        public int getBag(){
            return bag;
        }
        public int getVacuumedDirt(){
            return vacuumedDirt;
        }
        public int getSteps(){
            return steps;
        }
        public boolean move(BoardD boardD){
            Random random = new Random();
            int direction =(int) random.nextInt(8);

            int newX = xCoordinate;
            int newY = yCoordinate;

            switch (direction){
                case 0://Norte
                    newY--;
                    break;

                case 1://Noreste
                    newX++;
                    newY--;
                    break;

                case 2://Este
                    newX++;
                    break;

                case 3://Sureste
                    newX++;
                    newY++;
                    break;

                case 4://Sur
                    newY++;
                    break;

                case 5://Suroeste
                    newX--;
                    newY++;
                    break;

                case 6://Oeste
                    newX--;
                    break;

                case 7://Noroeste
                    newX--;
                    newY--;
                    break;

                case 8://No se mueve
                    break;
            }
            if (boardD.isValidToMove(newX, newY)){
                xCoordinate = newX;
                yCoordinate = newY;
                steps++;
                Battery = currentBattery - 1;
            }

            return false;
        }
        public void cleanTile(BoardD boardD){
            int levelofdirt = boardD.getTileDirtyLevel(xCoordinate,yCoordinate);
            if(levelofdirt>0){
                vacuumedDirt+= levelofdirt;
                if (vacuumedDirt > bag) {
                    vacuumedDirt=bag;
                }
                boardD.cleanTile(xCoordinate,yCoordinate);
            }
        }


        public void decreaseBattery() {
            Battery=Battery-1;
        }

        public void emptyTrash() {
            vacuumedDirt=0;
        }
    }


}
