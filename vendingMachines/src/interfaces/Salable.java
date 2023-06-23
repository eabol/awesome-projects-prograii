package interfaces;

import main.Money;
import main.Status;

public interface Salable {
    final float[] values = {20.0f, 10.0f, 5.0f, 2.0f, 1.0f, 0.5f, 0.2f, 0.1f, 0.05f};
    public Money manageChange(Money money, float price);

    public Status possibleJam();
    public Status possibleFailure();
}
