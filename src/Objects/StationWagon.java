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
import Interfaces.RemoteDeliverAndDrop;

import java.time.LocalDate;
import java.time.Period;

public class StationWagon extends Car implements RemoteDeliverAndDrop {

    private double loadingCapacity;

    public StationWagon(int plateNumber, int numberOfTires, double dailyFee, String color, int seatingCapacity, int numberOfDoors, double loadingCapacity) {
        super(plateNumber, numberOfTires, dailyFee, color, seatingCapacity, numberOfDoors);
        this.loadingCapacity = loadingCapacity;
    }

    public double getLoadingCapacity() {
        return loadingCapacity;
    }

    public void setLoadingCapacity(double loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }

    @Override
    public void rentMe(LocalDate startDate, LocalDate endDate, String startLocation, String endLocation) throws SorryWeDontHaveThatOneException {
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
        return "StationWagon" + super.toString();
    }

    @Override
    public void rentMe(LocalDate startDate, LocalDate endDate) throws SorryWeDontHaveThatOneException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
