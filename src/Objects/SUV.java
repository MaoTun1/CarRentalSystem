/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Metehan ÇEVİK
 */


import AbstractClasses.Car;
import Exceptions.NoCancellationYouMustPayException;
import Exceptions.SorryWeDontHaveThatOneException;

import java.time.LocalDate;
import java.time.Period;

public class SUV extends Car {
    private String wd;

    public SUV(int plateNumber, int numberOfTires, double dailyFee, String color, int seatingCapacity, int numberOfDoors, String wd) {
        super(plateNumber, numberOfTires, dailyFee, color, seatingCapacity, numberOfDoors);
        this.wd = wd;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    
    @Override
    public void rentMe(LocalDate startDate, LocalDate endDate) throws SorryWeDontHaveThatOneException {
        if (startDate.isAfter(endDate) && (startDate.isAfter(this.getStartDate()) && startDate.isBefore(this.getEndDate()))
                && (endDate.isAfter(this.getStartDate()) && endDate.isBefore(this.getEndDate())) && startDate.isBefore(LocalDate.now()) && endDate.isBefore(LocalDate.now())) {
            throw new SorryWeDontHaveThatOneException("No available vehicle");
        } else {
            this.setStartDate(startDate);
            this.setEndDate(endDate);
            this.setRented(true);
        }
    }

    
    @Override
    public void dropMe() {
        Period period = Period.between(this.getEndDate(), this.getStartDate());
        int totalDay = Math.abs(period.getDays());
        System.out.println("Total amount is : " + totalDay * this.getDailyFee());
        this.setRented(false);
    }

    @Override
    public String toString() {
        return "SUV" + super.toString();
    }
 
}

