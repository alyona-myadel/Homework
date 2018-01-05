package by.myadel.Homework13.Task3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestWithdrawMoney extends Assert {
    private BelarusbankATM belarusbankATM = new BelarusbankATM();

    @Before
    public void replenishBalance() {
        boolean result = belarusbankATM.replenish(150);
    }

    @Test
    public void testWithdrawMoney() {
        List<Integer> list = belarusbankATM.withdraw(50);
        assertNotNull(list);
    }
}