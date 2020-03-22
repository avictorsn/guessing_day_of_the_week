/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend.core;

import backend.model.SpecificDate;

/**
 *
 * @author anton
 */
public class Doomsday {
    
    private SpecificDate date;
    private int markup;     //  1 = Domingo; 7 = Sábado;

    public Doomsday(SpecificDate date) {
        this.date = date;
        int year = this.date.getYear();
        if(year >= 1800 && year <= 1899){
            this.markup = 6;
        }
        else if(year >=1900 && year <= 1999){
            this.markup = 4;
        }
        else if(year >=2000 && year <= 2099){
            this.markup = 3;
        }
        else{
            this.markup = 7;
        }
    }
    
    public int findDay(){
        int day = this.date.getDay();
        int month = this.date.getMonth();
        int year = this.date.getYear();
        int lastDigits = Integer.parseInt(this.lastTwoDigits(year));
        int doomsday = (Math.floorDiv(lastDigits, 12) + lastDigits%12 + Math.floorDiv((lastDigits%12), 4))%7 + markup;
        Validator val = new Validator();
        int markupDay;
        int diff;
        int dayOfTheWeek;
        switch(month){
            case 1:
                //
                markupDay = 3;
                if(val.isLeap(year)){
                    markupDay = 4;
                }
                diff = Math.abs( day - markupDay)%7;
                if(day > markupDay){
                    dayOfTheWeek = (doomsday + diff)%7;
                }
                else{
                    dayOfTheWeek = (doomsday - diff)%7;
                }                break;
            case 2:
                markupDay = 28;
                if(val.isLeap(year)){
                    markupDay = 29;
                }
                //
                diff = Math.abs( day - markupDay)%7;
                if(day > markupDay){
                    dayOfTheWeek = (doomsday + diff)%7;
                }
                else{
                    dayOfTheWeek = (doomsday - diff)%7;
                }
                break;
            case 3:
                //
                markupDay = 0;
                diff = Math.abs( day - markupDay)%7;
                if(day > markupDay){
                    dayOfTheWeek = (doomsday + diff)%7;
                }
                else{
                    dayOfTheWeek = (doomsday - diff)%7;
                }    
                break;
            case 4:
                //
                markupDay = 4;
                diff = Math.abs( day - markupDay)%7;
                if(day > markupDay){
                    dayOfTheWeek = (doomsday + diff)%7;
                }
                else{
                    dayOfTheWeek = (doomsday - diff)%7;
                }    
                break;
            case 5:
                //
                markupDay = 9;
                diff = Math.abs( day - markupDay)%7;
                if(day > markupDay){
                    dayOfTheWeek = (doomsday + diff)%7;
                }
                else{
                    dayOfTheWeek = (doomsday - diff)%7;
                }    
                break;
            case 6:
                //
                markupDay = 6;
                diff = Math.abs( day - markupDay)%7;
                if(day > markupDay){
                    dayOfTheWeek = (doomsday + diff)%7;
                }
                else{
                    dayOfTheWeek = (doomsday - diff)%7;
                }   
                break;
            case 7:
                //
                markupDay = 11;
                diff = Math.abs( day - markupDay)%7;
                if(day > markupDay){
                    dayOfTheWeek = (doomsday + diff)%7;
                }
                else{
                    dayOfTheWeek = (doomsday - diff)%7;
                }    
                break;
            case 8:
                //
                markupDay = 8;
                diff = Math.abs( day - markupDay)%7;
                if(day > markupDay){
                    dayOfTheWeek = (doomsday + diff)%7;
                }
                else{
                    dayOfTheWeek = (doomsday - diff)%7;
                }
                break;
            case 9:
                //
                markupDay = 5;
                diff = Math.abs( day - markupDay)%7;
                if(day > markupDay){
                    dayOfTheWeek = (doomsday + diff)%7;
                }
                else{
                    dayOfTheWeek = (doomsday - diff)%7;
                }  
                break;
            case 10:
                //
                markupDay = 10;
                diff = Math.abs( day - markupDay)%7;
                if(day > markupDay){
                    dayOfTheWeek = (doomsday + diff)%7;
                }
                else{
                    dayOfTheWeek = (doomsday - diff)%7;
                }
                break;
            case 11:
                //
                markupDay = 7;
                diff = Math.abs( day - markupDay)%7;
                if(day > markupDay){
                    dayOfTheWeek = (doomsday + diff)%7;
                }
                else{
                    dayOfTheWeek = (doomsday - diff)%7;
                } 
                break;
            default:
                //
                markupDay = 12;
                diff = Math.abs( day - markupDay)%7;
                if(day > markupDay){
                    dayOfTheWeek = (doomsday + diff)%7;
                }
                else{
                    dayOfTheWeek = (doomsday - diff)%7;
                }
                break;
        }
        return dayOfTheWeek;
    }
    
    public String lastTwoDigits(int year){
        String strYear = String.valueOf(year);
        String twoDigits = strYear.substring(1);
        return twoDigits;
    }

}
