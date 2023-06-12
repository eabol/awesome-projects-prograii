package WorkinProgress;


public class VacuumCleaner extends MovingEntity {

    int bag;

    int currentBattery;

    int maxBattery;

    int vacuumedDirt;


    public VacuumCleaner(int id, int xCoordinate, int yCoordinate,
                         int bag, int currentBattery, int maxBattery, int vacuumedDirt) {
        super(id,xCoordinate,yCoordinate);
        this.bag = bag;
        this.currentBattery = currentBattery;
        this.maxBattery = maxBattery;
        this.vacuumedDirt = vacuumedDirt;
    }

 public void clean()//necesitamos un metodo que nos de la cantidad de suciedad en el cuadrado {
    
            if (currentdirt >= bag) {
                return; // No se puede recoger más suciedad si la bolsa está llena
            } else {
                currentdirt -= 1; // La aspiradora quita un nivel de suciedad del cuadrado

                if (score.getSteps() % 3 == 0) {
                    battery -= 1; // La batería se disminuye cada 3 pasos
                }

                if (bag + 1 <= maxbagcapacity) {
                    bag += 1; // La aspiradora guarda la suciedad en la bolsa
                }
            }
        }


}
