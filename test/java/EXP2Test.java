import model.TestParam;
import org.apache.commons.collections4.functors.FalsePredicate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class EXP2Test {

    private final String target;
    private final String expect;

    @Parameterized.Parameters(name = "{index}.\tCASE:[{2}]\tTARGET:{0}\tEXPECT:{1}")
    public static Collection<Object[]> setParam() {
        Collection<Object[]> paramSet = new ArrayList<Object[]>();
        List<TestParam> testParams = Utils.readExcel();
        for (TestParam testParam: testParams) {
            paramSet.add(new Object[] {EXP2.nextDate(testParam.getYear(), testParam.getMonth(), testParam.getDay()), testParam.getExpectOutput(), testParam.getState()});
        }
        return paramSet;
    }

    public EXP2Test(String target, String except, String testCase){
        this.target = target;
        this.expect = except;
    }

    @Test
    public void nextDate() {
        assertEquals(target, expect);
    }

}


