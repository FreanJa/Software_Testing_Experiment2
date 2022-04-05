package model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class TestParam {

    @ExcelProperty(index = 1)
    private int year;

    @ExcelProperty(index = 2)
    private int month;

    @ExcelProperty(index = 3)
    private int day;

    @ExcelProperty(index = 4)
    private String expectOutput;

    @ExcelProperty(index = 5)
    private String state;

}
