package model;

import lombok.Data;

@Data
public class DateParam {
    private int year;
    private int month;
    private int day;

    public DateParam(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
