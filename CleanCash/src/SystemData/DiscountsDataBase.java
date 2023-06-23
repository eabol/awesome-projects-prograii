package SystemData;

import Exceptions.CodeNotFoundException;

public class DiscountsDataBase {
    String[][] sales = new String[4][2];

    public DiscountsDataBase() {
        sales[0][0] = "summertime";
        sales[0][1] = "10";
        sales[1][0] = "5to5";
        sales[1][1] = "5";
        sales[2][0] = "sweetycash";
        sales[2][1] = "2";
    }

    public String getSaleDiscount(String code) {
        try {
            for (int i = 0; i < sales.length - 1; i++) {
                if (sales[i][0].equals(code)) {
                    return sales[i][1];
                }
            }
            throw new CodeNotFoundException();
        } catch (CodeNotFoundException e) {
            e.logException();
            return null;
        }
    }

}
