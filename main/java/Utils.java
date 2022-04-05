import com.alibaba.excel.EasyExcel;
import listener.ExcelListener;
import model.DateParam;
import model.TestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Utils {
//    public static List<model.TestParam> paramSet = new ArrayList<>();
    public static void main(String[] args) {
        int y, m, d;
        StringBuilder str;
        boolean b1 = false, b2 = false, b3 = false;
        for (int year = 1; year < 5; year++)
            for (int month = 1; month < 7; month++)
                for (int day = 1; day < 8; day++){
                    switch ( year ) {
                        case 1:
                            y = 1899;
                            break;
                        case 2:
                            y = randomNum(0);
                            b1 = true;
                            break;
                        case 3:
                            y = randomNum(1);
                            b1 = true;
                            break;
                        default:
                            y = 2051;
                            break;
                    }
                    switch ( month ){
                        case 1:
                            m = 0;
                            break;
                        case 2:
                            m = 2;
                            b2 = true;
                            break;
                        case 3:
                            m = 12;
                            b2 = true;
                            break;
                        case 4:
                            m = randomNum(2);
                            b2 = true;
                            break;
                        case 5:
                            m = randomNum(3);
                            b2 = true;
                            break;
                        default:
                            m = 13;
                            break;
                    }
                    switch ( day ){
                        case 1:
                            d = 0;
                            break;
                        case 2:
                            d = randomNum(4);
                            b3 = true;
                            break;
                        case 3:
                            d = 28;
                            b3 = true;
                            break;
                        case 4:
                            d = 29;
                            break;
                        case 5:
                            d = 30;
                            break;
                        case 6:
                            d = 31;
                            break;
                        default:
                            d = 32;
                            break;
                    }
                    if ( b1 && b2 && b3 ) {
                        str = new StringBuilder().append(y).append(m).append(d+1);
                        System.out.println(y + "," + m + "," + d + "," + str);
                        b1 = false;
                        b2 = false;
                        b3 = false;
                        continue;
                    }
                    System.out.println(y + "," + m + "," + d + ", ");
                    b1 = false;
                    b2 = false;
                    b3 = false;
                }
    }

    private static int randomNum(int flag) {
        int result;
        switch (flag) {
            // generate leap year
            case 0:
                do
                    result = randomYear();
                while (result % 4 != 0);
                break;
            // generate normal year
            case 1:
                do
                    result = randomYear();
                while (result % 4 == 0);
                break;
            // generate solar month of 31 days
            case 2:
                result = randomMonth(true);
                break;
            // generate solar month of 30 days
            case 3:
                result = randomMonth(false);
                break;
            default:
                result = (int)(Math.random() * 27 + 1);
                break;
        }
        return result;
    }

    private static int randomYear() {
        return (int)(Math.random() * 151 + 1900);
    }

    // true --> solar month of 31 days
    // false --> solar month of 30 days
    private static int randomMonth(boolean flag) {
        int[] monthOf31 = {1, 3, 5, 7, 8, 10};
        int[] monthOf30 = {4, 6, 9, 11};
        return flag ?
                monthOf31[(int)(Math.random()*monthOf31.length)]:
                monthOf30[(int)(Math.random()*monthOf30.length)];
    }

    private List<DateParam> traverse() {
        List<DateParam> testCases = new ArrayList<>();
        int y, m, d;
        for (int year = 1; year < 5; year++)
            for (int month = 1; month < 7; month++)
                for (int day = 1; day < 8; day++){
                    switch (year) {
                        case 1:
                            y = 1899;
                            break;
                        case 2:
                            y = 2000;
                            break;
                        case 3:
                            y = 2002;
                            break;
                        default:
                            y = 2051;
                            break;
                    }
                    switch (month){
                        case 1:
                            m = 0;
                            break;
                        case 2:
                            m = 2;
                            break;
                        case 3:
                            m = 12;
                            break;
                        case 4:
                            m = 1;
                            break;
                        case 5:
                            m = 4;
                            break;
                        default:
                            m = 13;
                            break;
                    }
                    switch (day){
                        case 1:
                            d = 0;
                            break;
                        case 2:
                            d = 1;
                            break;
                        case 3:
                            d = 28;
                            break;
                        case 4:
                            d = 29;
                            break;
                        case 5:
                            d = 30;
                            break;
                        case 6:
                            d = 31;
                            break;
                        default:
                            d = 32;
                            break;
                    }
                    testCases.add(new DateParam(year, month, day));
                }
        return testCases;
    }

    public static List<TestParam> readExcel() {
        List<TestParam> paramSet = new ArrayList<>();
        String fileName = "src/main/resources/Table.xlsx";
        EasyExcel.read(fileName, TestParam.class, new ExcelListener(paramSet)).sheet(1).doRead();
        System.out.println(paramSet);
        return paramSet;
    }



}

