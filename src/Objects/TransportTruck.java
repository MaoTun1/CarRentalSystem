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
import AbstractClasses.Truck;
import Exceptions.NoCancellationYouMustPayException;
import Exceptions.OverWeightException;
import Exceptions.SorryWeDontHaveThatOneException;

import java.time.LocalDate;
import java.time.Period;

public class TransportTruck extends Truck {

    private boolean canGoAbroad;

    public TransportTruck(int plateNumber, int numberOfTires, double dailyFee, double loadingCapacity, boolean canGoAbroad) {
        super(plateNumber, numberOfTires, dailyFee, loadingCapacity);
        this.canGoAbroad = canGoAbroad;
    }

    public boolean isCanGoAbroad() {
        return canGoAbroad;
    }

    public void setCanGoAbroad(boolean canGoAbroad) {
        this.canGoAbroad = canGoAbroad;
    }

    @Override
    public void bookMe(LocalDate startDate, LocalDate endDate) throws SorryWeDontHaveThatOneException {
        if (startDate.isAfter(endDate) && (startDate.isAfter(this.getStartDate()) && startDate.isBefore(this.getEndDate()))
                && (endDate.isAfter(this.getStartDate()) && endDate.isBefore(this.getEndDate())) && startDate.isBefore(LocalDate.now()) && endDate.isBefore(LocalDate.now())) {
            throw new SorryWeDontHaveThatOneException("No available vehicle");
        } else {
            this.setStartDate(startDate);
            this.setEndDate(endDate);
            this.setBooked(true);
        }
    }

    @Override
    public void cancelMe() throws NoCancellationYouMustPayException {
        if (LocalDate.now().isAfter(this.getStartDate())) {
            throw new NoCancellationYouMustPayException("You already begin");
        } else {
            this.setStartDate(null);
            this.setEndDate(null);
            this.setBooked(false);
        }
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
    public void loadMe(double loadAmount) throws OverWeightException {
        if (this.getLoadingCapacity() >= loadAmount) {
            this.setLoadingCapacity(this.getLoadingCapacity() - loadAmount);
        } else {
            throw new OverWeightException("Overweight!");
        }
    }

    @Override
    public String toString() {
        return "TransportTruck" + super.toString();
    }
}
