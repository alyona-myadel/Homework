package by.myadel.Homework13.Task3;

import org.junit.Assert;
import org.junit.Test;

public class TestReplenishBalance extends Assert {
    private BelarusbankATM belarusbankATM = new BelarusbankATM();

    @Test
    public void testReplenishBalance1() {
        boolean result = belarusbankATM.replenish(150);
        assertTrue(result);
    }

    @Test
    public void testReplenishBalance2() {
        boolean result = belarusbankATM.replenish(170);
        assertTrue(result);
    }

    @Test
    public void testReplenishBalance3() {
        boolean result = belarusbankATM.replenish(210);
        assertTrue(result);
    }

    @Test
    public void testReplenishBalance4() {
        boolean result = belarusbankATM.replenish(10);
        assertFalse(result);
    }

    @Test
    public void testReplenishBalance5() {
        boolean result = belarusbankATM.replenish(499990);
        assertTrue(result);
    }
}