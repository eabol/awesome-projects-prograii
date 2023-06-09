package SystemManagement;

import DataClasses.Entity;
import SystemData.DiscountsDataBase;

public class DiscountsManager implements DataManager{

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

    public int getDiscount(String code){
        String saleDiscount = discountsDataBase.getSaleDiscount(code);
        if (saleDiscount != null){
            int discount = Integer.parseInt(saleDiscount);
            return discount;
        }
        else return 0;
    }
}
