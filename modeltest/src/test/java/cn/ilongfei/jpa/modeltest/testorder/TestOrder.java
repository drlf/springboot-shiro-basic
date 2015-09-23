package cn.ilongfei.jpa.modeltest.testorder;

import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestOrder {
    private static final Logger log = Logger.getLogger(TestOrder.class);
    

    @Test
    public void testSecond() throws Exception {
        log.info("------2--------");

    }

    @Test
    public void testFirst() throws Exception {
        log.info("------1--------");
    }
    
    @Test
    public void testThird() throws Exception {
        log.info("------3--------");
    }

}