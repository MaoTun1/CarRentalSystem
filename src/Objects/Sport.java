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
import Interfaces.Book;
import Interfaces.RemoteDeliverAndDrop;

import java.time.LocalDate;
import java.time.Period;

public class Sport extends Car implements Book, RemoteDeliverAndDrop {

    private int hp;

    public Sport(int plateNumber, int numberOfTires, double dailyFee, String color, int seatingCapacity, int numberOfDoors, int hp) {
        super(plateNumber, numberOfTires, dailyFee, color, seatingCapacity, numberOfDoors);
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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
        return "Sport" + super.toString();
    }
}
