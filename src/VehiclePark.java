/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Metehan ÇEVİK
 */
import AbstractClasses.Truck;
import AbstractClasses.Vehicle;
import Exceptions.NoCancellationYouMustPayException;
import Exceptions.OverWeightException;
import Exceptions.SorryWeDontHaveThatOneException;
import Interfaces.Book;
import Objects.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VehiclePark {

    File f = new File("vehicle.abc");
    List<Vehicle> vehicles = initialVehicles();
    List<String> dailyReport = new ArrayList<>();

    private List<Vehicle> initialVehicles() {
        List<Vehicle> vehicleArrayList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(f);
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                Vehicle[] x = (Vehicle[]) ois.readObject(); //must know what to read
                vehicleArrayList = Arrays.asList(x);
            } //must know what to read
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot read from the specified file");
        } catch (ClassNotFoundException ex) {
            System.out.println("the class doesnt exist");
        }
        return vehicleArrayList;
    }

    public void updateVehicleFile() {
        Vehicle[] vehicleArray = new Vehicle[vehicles.size()];
        for (int i = 0; i < vehicles.size(); i++) {
            vehicleArray[i] = vehicles.get(i);
        }
        try {
            FileOutputStream fos = new FileOutputStream(f);
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(vehicleArray); //write the object
            } //write the object
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Cannot write into the specified file");
        }
    }

    public Vehicle findVehicle(int id) throws Exception {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getId() == id) {
                return vehicles.get(i);
            }
        }
        throw new Exception("This id does not exist");

    }

    public void displayVehicles() {
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i));
        }
    }

    public void displayAvailableVehicles() {
        for (int i = 0; i < vehicles.size(); i++) {
            if (!vehicles.get(i).isBooked() && !vehicles.get(i).isRented()) {
                System.out.println(vehicles.get(i));
            }
        }
    }

    public void displayAvailableVehiclesWithType(int num) {
        switch (num) {
            case 1:
                for (int i = 0; i < vehicles.size(); i++) {
                    if (!vehicles.get(i).isBooked() && !vehicles.get(i).isRented() && vehicles.get(i) instanceof SmallTruck) {
                        System.out.println(vehicles.get(i));
                    }
                }
                break;
            case 2:
                for (int i = 0; i < vehicles.size(); i++) {
                    if (!vehicles.get(i).isBooked() && !vehicles.get(i).isRented() && vehicles.get(i) instanceof Sport) {
                        System.out.println(vehicles.get(i));
                    }
                }
                break;
            case 3:
                for (int i = 0; i < vehicles.size(); i++) {
                    if (!vehicles.get(i).isBooked() && !vehicles.get(i).isRented() && vehicles.get(i) instanceof StationWagon) {
                        System.out.println(vehicles.get(i));
                    }
                }
                break;
            case 4:
                for (int i = 0; i < vehicles.size(); i++) {
                    if (!vehicles.get(i).isBooked() && !vehicles.get(i).isRented() && vehicles.get(i) instanceof SUV) {
                        System.out.println(vehicles.get(i));
                    }
                }
                break;
            case 5:
                for (int i = 0; i < vehicles.size(); i++) {
                    if (!vehicles.get(i).isBooked() && !vehicles.get(i).isRented() && vehicles.get(i) instanceof TransportTruck) {
                        System.out.println(vehicles.get(i));
                    }
                }
                break;
            default:
                System.out.println("Wrong choice");
                break;
        }

    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        dailyReport.add(vehicle.getId() + " " + vehicle.getPlateNumber() + " added");
    }

    public void removeVehicle(Vehicle vehicle) {
        int id = vehicle.getId();
        int plate = vehicle.getPlateNumber();
        vehicles.remove(vehicle);
        dailyReport.add(id + " " + plate + " removed");
    }

    public void bookVehicle(Vehicle vehicle, LocalDate startDate, LocalDate endDate) throws SorryWeDontHaveThatOneException {
        if (vehicle instanceof Book) {
            ((Book) vehicle).bookMe(startDate, endDate);
            dailyReport.add(vehicle.getId() + " " + vehicle.getPlateNumber() + " booked");
        } else {
            System.out.println("This vehicle can not book");
        }
    }

    public void cancelBooking(Vehicle vehicle) throws NoCancellationYouMustPayException {
        if (vehicle instanceof Book) {
            ((Book) vehicle).cancelMe();
            dailyReport.add(vehicle.getId() + " " + vehicle.getPlateNumber() + " canceled");
        } else {
            System.out.println("This vehicle can not cancel");
        }
    }

    public void rentVehicle(Vehicle vehicle, LocalDate startDate, LocalDate endDate) throws SorryWeDontHaveThatOneException {
        vehicle.rentMe(startDate, endDate);
        dailyReport.add(vehicle.getId() + " " + vehicle.getPlateNumber() + " rented");
    }

    public void dropVehicle(Vehicle vehicle) {
        vehicle.dropMe();
        dailyReport.add(vehicle.getId() + " " + vehicle.getPlateNumber() + " dropped");
    }

    public void load(Vehicle vehicle, double loadAmount) throws OverWeightException {
        if (vehicle instanceof Truck) {
            ((Truck) vehicle).loadMe(loadAmount);
            dailyReport.add(vehicle.getId() + " " + vehicle.getPlateNumber() + " loaded");
        } else {
            System.out.println("This vehicle can not load");
        }
    }

    public void dailyReport(String fileName) {
        File file = new File(fileName + ".txt");
        try {
            try (PrintWriter prn = new PrintWriter(file)) {
                for (int i = 0; i < dailyReport.size(); i++) {
                    String line = dailyReport.get(i);
                    prn.print(line);
                    prn.println("");
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        dailyReport.clear();
    }
}
