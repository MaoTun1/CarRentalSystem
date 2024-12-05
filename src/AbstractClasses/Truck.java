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
import Exceptions.OverWeightException;
import Interfaces.Book;

public abstract class Truck extends Vehicle implements Book {

    private double loadingCapacity;

    public Truck(int plateNumber, int numberOfTires, double dailyFee, double loadingCapacity) {
        super(plateNumber, numberOfTires, dailyFee);
        this.loadingCapacity = loadingCapacity;
    }

    public double getLoadingCapacity() {
        return loadingCapacity;
    }

    public void setLoadingCapacity(double loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }

    public abstract void loadMe(double loadAmount) throws OverWeightException;
}
