package SystemManagement;

import DataClasses.Entity;
import SystemData.DiscountsDataBase;

public class DiscountsManager implements DataManager {

    private DiscountsDataBase discountsDataBase = new DiscountsDataBase();

    @Override
    public void add(Entity newEntity) {

    }

    @Override
    public void remove(Entity removedEntity) {

    }

    @Override
    public void identify(Entity entity) {

    }

    public int getDiscount(String code) {
        String saleDiscount = discountsDataBase.getSaleDiscount(code);
        if (saleDiscount != null) {
            try {
                int discount = Integer.parseInt(saleDiscount);
                return discount;
            } catch (NumberFormatException e) {
                System.err.println("Invalid code");
                return 0;
            }
        } else
            return 0;
    }
}

