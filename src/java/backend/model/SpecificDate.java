/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend.model;

/**
 *
 * @author anton
 */
public class SpecificDate {
    
    private int day;
    private int month;
    private int year;

    public SpecificDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
       public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}