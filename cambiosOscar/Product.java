public abstract class Product {
    protected String name;
    protected double price;
    public int[] amount;


    public Product() {
        this.name = this.name;
        this.price = this.price;
        this.amount =new int[3];
    }
    public Product(String name, double price, int[] amount) {
        this.name = this.name;
        this.price = this.price;
        this.amount = amount;
    }

    public void setCantidad(int i,int value){
        this.amount[i]=value;
    }

    public int getCantidad(int i){
        return amount[i];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void vender(int i){
        this.amount[i]--;
    }
}
