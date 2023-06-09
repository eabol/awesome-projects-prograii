package SystemManagement;

import DataClasses.Entity;
import SystemData.MemberDataBase;

public class MemberManager implements DataManager{

    private MemberDataBase memberDataBase = new MemberDataBase();

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
        String saleDiscount = memberDataBase.getSaleDiscount(code);
        if (saleDiscount != null){
            int discount = Integer.parseInt(saleDiscount);
            return discount;
        }
        else return 0;
    }
}
