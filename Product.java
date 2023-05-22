public abstract class Product{
    protected String name;
    protected double price;

    protected int id;
    public int[] product;
    public int[] prize;
    public int[] amount;

    public Product(String name, double price, int id){
        this.name = name;
        this.price = price;

        this.id = id;
        this.amount=new int[3];
    }
    public String getName(){
        return name;
    }

    public int getAmount(int i) {
        return amount[i];
    }

    public double getPrice(){
        return price;
    }

    public String toString(){
        return name + " " + price + " " + id;
    }


    public abstract void setPrize();

    public abstract void amount();

    public abstract boolean isAvailable();

    public void sell(int i){
        amount[i]--;
    }



}


