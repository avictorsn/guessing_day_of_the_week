/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend.core;

import backend.model.SpecificDate;
import java.util.stream.IntStream;

/**
 *
 * @author anton
 */
public class Validator {
    
    private String errorMessage;


    public Validator() {
    }
    
    public boolean validate(SpecificDate date){
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear();
        
        int[] fullMonths = {1, 3, 5, 7, 8, 10, 12};
        boolean isFullMonth = IntStream.of(fullMonths).anyMatch(x -> x == month);
        
        //  Verifica ano;
        if(year < 1800 || year > 2199){
            this.errorMessage = "Ano inválido!";
            return false;
        }
        
        //  Verifica mês;
        if(month < 1 || month > 12){
            this.errorMessage = "Mês inválido!";
            return false;
        }
        
        //  Verifica dia;
        if(day < 1 || day > 31){
            this.errorMessage = "Dia inválido!";
            return false;
        }
        else if(day > 29 && month == 2){
            this.errorMessage = "Dia inválido!";
            return false;
        }
        else if(day == 29 && !this.isLeap(year)){
            this.errorMessage = "Dia inválido!";
            return false;
        }
        else if(!isFullMonth && day == 31){
            this.errorMessage = "Dia inválido!";
            return false;
        }
        else{
            return true;
        }
        
    }

    protected boolean isLeap(int year){
        if(year%400 == 0){
            return true;
        }
        else return (year%4 == 0) && (year%100 != 0);
    }
    
    
    public String getErrorMessage() {
        return errorMessage;
    }
}


