public class Drinks extends Product implements Salable{

    public Drinks(String name, double price, int id) {
        super(name, price);
    }


    @Override
    public void setPrize() {

    }

    @Override
    public void amount(int n) {

    }

    @Override
    public void amount() {

    }

    @Override
    public boolean isAvailable() {
        return false;
    }
    public double mililiters;
    public double getMililiters(){
        return mililiters;
    }
    public void setMililiters(double mililiters){
        this.mililiters = mililiters;
    }

}