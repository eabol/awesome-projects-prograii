package test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import models.CoinModel;
import org.junit.Test;
import controllers.CoinController;

public class Test_CoinController {

    @Test
    public void testCreateCoinList() {
        CoinController coinController = new CoinController();
        List<CoinModel> coinList = coinController.createCoinList(2, 3, 4);

        assertEquals(3, coinList.size());

        CoinModel firstCoin = coinList.get(0);
        assertEquals(0.50, firstCoin.value, 0.001);
        assertEquals(2, firstCoin.quantity);

        CoinModel secondCoin = coinList.get(1);
        assertEquals(0.20, secondCoin.value, 0.001);
        assertEquals(3, secondCoin.quantity);

        CoinModel thirdCoin = coinList.get(2);
        assertEquals(0.05, thirdCoin.value, 0.001);
        assertEquals(4, thirdCoin.quantity);
    }

    @Test
    public void testCreateCoinListWithZeroQuantities() {
        CoinController coinController = new CoinController();
        List<CoinModel> coinList = coinController.createCoinList(0, 0, 0);

        assertEquals(3, coinList.size());

        for (CoinModel coin : coinList) {
            assertEquals(0, coin.quantity);
        }
    }
}
