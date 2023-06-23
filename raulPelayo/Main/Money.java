
public class Money  {
    private float[] value;
    private int[] amount;

    public Money() {
        this.value = new float[]{20, 10, 5, 2, 1, 0.5F, 0.2F, 0.05F};
        this.amount = new int[]{0,0,0,0,0,0,0,0};
    }

    public int getIndex(float val) {
        for (int i = 0; i < this.value.length; i++) {
            if (this.value[i]==val){
                return i;
            }
        }
        return -1;
    }

    //añadir dinero a la maquina
    public void insetMoney(float value, int amount) {
        int index=this.getIndex(value);
        if (index!=-1){
            this.amount[index]+=amount;
        }
    }

    //quitar dinero a la maquina
    public void removeMoney(float value, int amount) {
        int index=this.getIndex(value);
        if (index!=-1){
            this.amount[index]-=amount;
        }
    }
    public float getAmount(float value) {
        int index=this.getIndex(value);
        if (index!=-1){
            return this.amount[index];
        }
        return -1;
    }

    public float getTotal() {
        float total=0;
        for (int i = 0; i < this.value.length; i++) {
            total+=this.value[i]*this.amount[i];
        }
        return total;
    }

    public void suma(Money money){
        for(float val: this.value){
            this.insetMoney(val, (int) money.getAmount(val));
        }
    }

    public boolean resta(Money money){
       for (float val: this.value){
           if (this.getAmount(val)<money.getAmount(val)){
               return false;
           }
       }
       for(float val: this.value){
           this.removeMoney(val, (int) - money.getAmount(val));
       }
       return true;
    }

    public void addAmount(float value, int amount) {
        int index=this.getIndex(value);
        if (index!=-1){
            this.amount[index]+=amount;
        }
    }

    public void info(){
        for (float val:this.value) {
        if (val>=5){
            System.out.println("Billetes de " +val+"€ ---> "+this.getAmount(val));
        }else{
            System.out.println("Monedas de " +val+"€ ---> "+this.getAmount(val));
        }
        }

    }
}
