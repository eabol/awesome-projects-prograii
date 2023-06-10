

public class vacuumCleaner extends entityInMovement {

    int bag;
    int battery;

    int maxbattery;

    int currentdirt;

    public vacuumCleaner(String id, int Xcoordinate,int Ycoordinate, int maxbattery,int bag) {
        super(id, Xcoordinate, Ycoordinate);
        this.bag = 0;
        this.maxbattery= maxbattery;
        this.battery = maxbattery;
        this.currentdirt = 0;
    }

    public void move(){
        if(battery <=0 ||currentdirt >= bag){
            //stop();
            return;
        }
    public void clean(){}//necesitamos un metodo que nos de la cantidad de suciedad en el cuadrado

    int direction=getmovingdirection();

    public void vacuumedDirty(int bag) {
        bag = bag + 1;
    }


    public boolean isbatterylow(){
        if (battery < 20){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isbatteryempty(){
        if (battery == 0){
            return true;
        }
        else{
            return false;
        }
    }
    public void isbagfull(int maximumbag){
        if (bag == 10){
            bag = 0;
        }
    }

    public void restbattery(int battery){
        battery = battery - 1;
    }

}
