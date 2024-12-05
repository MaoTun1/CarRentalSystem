/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractClasses;

import Interfaces.Book;

/**
 *
 * @author Metehan ÇEVİK
 *
 */
public abstract class Car extends Vehicle {

    private String color;
    private int seatingCapacity;
    private int numberOfDoors;

    public Car(int plateNumber, int numberOfTires, double dailyFee, String color, int seatingCapacity, int numberOfDoors) {
        super(plateNumber, numberOfTires, dailyFee);
        this.color = color;
        this.seatingCapacity = seatingCapacity;
        this.numberOfDoors = numberOfDoors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
