package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import controllers.BillController;
import models.BillModel;

public class Test_BillController {

    @Test
    public void testCreateBillList() {
        BillController billController = new BillController();
        List<BillModel> billList = billController.createBillList(2, 3, 4, 5, 6);

        assertEquals(5, billList.size());

        BillModel firstBill = billList.get(0);
        assertEquals(20.0, firstBill.value, 0.001);
        assertEquals(2, firstBill.quantity);

        BillModel secondBill = billList.get(1);
        assertEquals(10.0, secondBill.value, 0.001);
        assertEquals(3, secondBill.quantity);

        BillModel thirdBill = billList.get(2);
        assertEquals(5.0, thirdBill.value, 0.001);
        assertEquals(4, thirdBill.quantity);

        BillModel fourthBill = billList.get(3);
        assertEquals(2.0, fourthBill.value, 0.001);
        assertEquals(5, fourthBill.quantity);

        BillModel fifthBill = billList.get(4);
        assertEquals(1.0, fifthBill.value, 0.001);
        assertEquals(6, fifthBill.quantity);
    }

    @Test
    public void testCreateBillListWithZeroQuantities() {
        BillController billController = new BillController();
        List<BillModel> billList = billController.createBillList(0, 0, 0, 0, 0);

        assertEquals(5, billList.size());

        for (BillModel bill : billList) {
            assertEquals(0, bill.quantity);
        }
    }
}
