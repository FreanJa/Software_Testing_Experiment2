package listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import model.TestParam;

import java.util.*;

public class ExcelListener extends AnalysisEventListener<TestParam> {

    private final List<TestParam> paramSet;
    public ExcelListener(List<TestParam> paramSet) {
        this.paramSet = paramSet;
    }

    @Override
    public void invoke(TestParam testParam, AnalysisContext analysisContext) {
        paramSet.add(testParam);
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("Head:" + headMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//        System.out.println(paramSet);
    }
}
