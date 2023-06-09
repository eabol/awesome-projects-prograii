package Basis;

public interface Salable {
   final float[] value= new float[]{20, 10, 5, 2, 1, 0.5F, 0.2F, 0.05F};

   void pricing();

   int productQuantity(int price);

   void productQuantity();

   boolean available();

   void replenish(int n);

   public Money manageChange(Money clientMoney, float priceProduct);
   public Alert possibleJam();
   public Alert possibleFailure();
}
