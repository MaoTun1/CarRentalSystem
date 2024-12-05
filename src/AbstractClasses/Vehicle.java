/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractClasses;

/**
 *
 * @author Metehan ÇEVİK
 */
import Interfaces.Rent;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Vehicle implements Rent, Serializable {

    private int id;
    private static int count = 0;
    private final int plateNumber;
    private final int numberOfTires;
    private double dailyFee;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isRented;
    private boolean isBooked;

    public Vehicle(int plateNumber, int numberOfTires, double dailyFee) {
        this.plateNumber = plateNumber;
        this.numberOfTires = numberOfTires;
        this.dailyFee = dailyFee;
        this.isRented = false;
        this.isBooked = false;
        this.id += count;
        count++;
    }

    public int getId() {
        return id;
    }

    public int getPlateNumber() {
        return plateNumber;
    }

    public int getNumberOfTires() {
        return numberOfTires;
    }

    public double getDailyFee() {
        return dailyFee;
    }

    public void setDailyFee(double dailyFee) {
        this.dailyFee = dailyFee;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public double calculateFee(int numberOfDays) {
        return numberOfDays * this.dailyFee;
    }

    @Override
    public String toString() {
        return this.id + " " + this.dailyFee + " " + this.plateNumber + " " + this.isRented;
    }
}
