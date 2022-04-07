import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void readExcel() {
        Utils utils = new Utils();
        utils.readExcel();
    }

    @Test
    public void testAssert() {
        Boolean flag = Boolean.FALSE;
//        assertTrue("run", flag);
        fail("fail_run");
    }
}