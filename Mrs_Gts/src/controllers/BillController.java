package controllers;

import models.BillModel;

import java.util.ArrayList;
import java.util.List;

public class BillController {
    public List<BillModel> createBillList(
        int quantity1, int quantity2, int quantity3, int quantity4, int quantity5
    ) {
        final List<BillModel> bills = new ArrayList<BillModel>();
        bills.add(new BillModel(20, quantity1));
        bills.add(new BillModel(10, quantity2));
        bills.add(new BillModel(5, quantity3));
        bills.add(new BillModel(2, quantity4));
        bills.add(new BillModel(1, quantity5));
        return bills;
    }
}
