package Interface;

public interface Salable {
   final float[] value= new float[]{20, 10, 5, 2, 1, 0.5F, 0.2F, 0.05F};
   public Money manageChange(Money clientMoney, float priceProduct);
   public Alert possibleJam();
   public Alert possibleFailure();
}
