public class Money  {
    private float bill;
    private int[] coins;

    public Money(float bill, int[] coins) {
        this.bill = bill;
        this.coins =coins;
    }


    public float getBill() {
        return bill;
    }

    public void setBill(float bill) {
        this.bill = bill;
    }

    public int[] getCoins() {
        return coins;
    }

    public void setCoins(int[] coins) {
        this.coins = coins;
    }
}
