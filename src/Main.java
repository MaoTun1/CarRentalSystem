/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Metehan ÇEVİK
 */
import AbstractClasses.Vehicle;
import Objects.SUV;
import Objects.SmallTruck;
import Objects.Sport;
import Objects.StationWagon;
import Objects.TransportTruck;
import Objects.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<String> admins = new ArrayList<>();
        admins.add("admin");
        admins.add("mertali");
        admins.add("özay");
        admins.add("ege");
        admins.add("metehan");

        ArrayList<String> users = new ArrayList<>();
        users.add("user");
        users.add("user2");
        users.add("user3");
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you are admin please press 1, if you are customer press 2 ");
        int ch = scanner.nextInt();
        if (ch == 1) {
            System.out.println("Please write our username");
            String username = scanner.next();
            if (admins.contains(username)) {
                VehiclePark vehiclePark = new VehiclePark();
                int num = 0;
                do {
                    System.out.println("(Press 1) Display all vehicles.\n"
                            + " (Press 2) Display available vehicles.\n"
                            + " (Press 3) Add a new vehicle to the system.\n"
                            + " (Press 4) Remove vehicle.\n"
                            + " (Press 5) Reports.\n"
                            + " (Press 6) Quit.");
                    num = scanner.nextInt();
                    switch (num) {
                        case 1:
                            vehiclePark.displayVehicles();
                            break;
                        case 2:
                            vehiclePark.displayAvailableVehicles();
                            break;
                        case 3:
                            System.out.println("(Press 1) SmallTruck.\n"
                                    + " (Press 2) Sport.\n"
                                    + " (Press 3) StationWagon.\n"
                                    + " (Press 4) SUV.\n"
                                    + " (Press 5) TransportTruck.\n");
                            int choose = scanner.nextInt();
                            switch (choose) {
                                case 1:
                                    System.out.println("Plate Number:");
                                    int plateNumber = scanner.nextInt();
                                    System.out.println("Number Of Tires:");
                                    int numberOfTires = scanner.nextInt();
                                    System.out.println("Daily Fee:");
                                    double dailyFee = scanner.nextDouble();
                                    System.out.println("Loading Capacity:");
                                    double loadingCapacity = scanner.nextDouble();
                                    SmallTruck smallTruck = new SmallTruck(plateNumber, numberOfTires, dailyFee, loadingCapacity);
                                    vehiclePark.addVehicle(smallTruck);
                                    break;
                                case 2:
                                    System.out.println("Plate Number:");
                                    plateNumber = scanner.nextInt();
                                    System.out.println("Number Of Tires:");
                                    numberOfTires = scanner.nextInt();
                                    System.out.println("Daily Fee:");
                                    dailyFee = scanner.nextDouble();
                                    System.out.println("Color:");
                                    String color = scanner.next();
                                    System.out.println("Seating Capacity:");
                                    int seatingCapacity = scanner.nextInt();
                                    System.out.println("Number Of Doors:");
                                    int numberOfDoors = scanner.nextInt();
                                    System.out.println("Hp:");
                                    int hp = scanner.nextInt();
                                    Sport sport = new Sport(plateNumber, numberOfTires, dailyFee, color, seatingCapacity, numberOfDoors, hp);
                                    vehiclePark.addVehicle(sport);
                                    break;
                                case 3:
                                    System.out.println("Plate Number:");
                                    plateNumber = scanner.nextInt();
                                    System.out.println("Number Of Tires:");
                                    numberOfTires = scanner.nextInt();
                                    System.out.println("Daily Fee:");
                                    dailyFee = scanner.nextDouble();
                                    System.out.println("Color:");
                                    color = scanner.next();
                                    System.out.println("Seating Capacity:");
                                    seatingCapacity = scanner.nextInt();
                                    System.out.println("Number Of Doors:");
                                    numberOfDoors = scanner.nextInt();
                                    System.out.println("Loading Capacity:");
                                    loadingCapacity = scanner.nextDouble();
                                    StationWagon stationWagon = new StationWagon(plateNumber, numberOfTires, dailyFee, color, seatingCapacity, numberOfDoors, loadingCapacity);
                                    vehiclePark.addVehicle(stationWagon);
                                    break;
                                case 4:
                                    System.out.println("Plate Number:");
                                    plateNumber = scanner.nextInt();
                                    System.out.println("Number Of Tires:");
                                    numberOfTires = scanner.nextInt();
                                    System.out.println("Daily Fee:");
                                    dailyFee = scanner.nextDouble();
                                    System.out.println("Color:");
                                    color = scanner.next();
                                    System.out.println("Seating Capacity:");
                                    seatingCapacity = scanner.nextInt();
                                    System.out.println("Number Of Doors:");
                                    numberOfDoors = scanner.nextInt();
                                    System.out.println("Wd:");
                                    String wd = scanner.next();
                                    SUV suv = new SUV(plateNumber, numberOfTires, dailyFee, color, seatingCapacity, numberOfDoors, wd);
                                    vehiclePark.addVehicle(suv);
                                    break;
                                case 5:
                                    System.out.println("Plate Number:");
                                    plateNumber = scanner.nextInt();
                                    System.out.println("Number Of Tires:");
                                    numberOfTires = scanner.nextInt();
                                    System.out.println("Daily Fee:");
                                    dailyFee = scanner.nextDouble();
                                    System.out.println("Loading Capacity:");
                                    loadingCapacity = scanner.nextDouble();
                                    System.out.println("For abroad press 1");
                                    boolean isAbroad = scanner.nextInt() == 1;
                                    TransportTruck transportTruck = new TransportTruck(plateNumber, numberOfTires, dailyFee, loadingCapacity, isAbroad);
                                    vehiclePark.addVehicle(transportTruck);
                                    break;
                                default:
                                    System.out.println("Wrong choose");
                                    break;
                            }
                            break;
                        case 4:
                            System.out.println("Give id for remove");
                            int id = scanner.nextInt();
                            for (int i = 0; i < vehiclePark.vehicles.size(); i++) {
                                if (vehiclePark.vehicles.get(i).getId() == id) {
                                    Vehicle vehicle = vehiclePark.vehicles.get(i);
                                    vehiclePark.removeVehicle(vehicle);
                                    System.out.println("Removed");
                                } else {
                                    System.out.println("This id does not exist");
                                }
                            }
                            break;
                        case 5:
                            System.out.println("Give file name without extension");
                            String filename = scanner.next();
                            vehiclePark.dailyReport(filename);
                            break;
                        case 6:
                            System.out.println("QUIT. BYE");
                            vehiclePark.updateVehicleFile();
                            break;
                        default:
                            System.out.println("Wrong choose");
                            break;
                    }
                } while (num != 6);
            } else {
                System.out.println("You are not admin");
            }
        } else if (ch == 2) {
            System.out.println("Please write our username");
            String username = scanner.next();
            if (users.contains(username)) {
                VehiclePark vehiclePark = new VehiclePark();
                int num = 0;
                do {
                    System.out.println("(Press 1) Display all vehicles.\n"
                            + " (Press 2) Display available vehicles.\n"
                            + " (Press 3) Display available vehicles with type.\n"
                            + " (Press 4) Book vehicle.\n"
                            + " (Press 5) Cancel vehicle.\n"
                            + " (Press 6) Rent vehicle.\n"
                            + " (Press 7) Drop vehicle.\n"
                            + " (Press 8) Load vehicle.\n"
                            + " (Press 9) Quit.");
                    num = scanner.nextInt();
                    switch (num) {
                        case 1:
                            vehiclePark.displayVehicles();
                            break;
                        case 2:
                            vehiclePark.displayAvailableVehicles();
                            break;
                        case 3:
                            System.out.println("(Press 1) SmallTruck.\n"
                                    + " (Press 2) Sport.\n"
                                    + " (Press 3) StationWagon.\n"
                                    + " (Press 4) SUV.\n"
                                    + " (Press 5) TransportTruck.\n");
                            int choose = scanner.nextInt();
                            vehiclePark.displayAvailableVehiclesWithType(choose);
                            break;
                        case 4:
                            System.out.println("Enter id of vehicle");
                            int id = scanner.nextInt();
                            Vehicle vehicle = vehiclePark.findVehicle(id);
                            System.out.print("Enter a start date [dd. MMM. yyyy]: ");
                            String startString = scanner.next();
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd. MMM. yyyy");
                            LocalDate startDate = LocalDate.parse(startString, dtf);
                            System.out.print("Enter a end date [dd. MMM. yyyy]: ");
                            String endString = scanner.next();
                            LocalDate endDate = LocalDate.parse(endString, dtf);
                            vehiclePark.bookVehicle(vehicle, startDate, endDate);
                            break;
                        case 5:
                            System.out.println("Enter id of vehicle");
                            id = scanner.nextInt();
                            vehicle = vehiclePark.findVehicle(id);
                            vehiclePark.cancelBooking(vehicle);
                            break;
                        case 6:
                            System.out.println("Enter id of vehicle");
                            id = scanner.nextInt();
                            vehicle = vehiclePark.findVehicle(id);
                            System.out.print("Enter a start date [dd. MMM. yyyy]: ");
                            startString = scanner.next();
                            dtf = DateTimeFormatter.ofPattern("dd. MMM. yyyy");
                            startDate = LocalDate.parse(startString, dtf);
                            System.out.print("Enter a end date [dd. MMM. yyyy]: ");
                            endString = scanner.next();
                            endDate = LocalDate.parse(endString, dtf);
                            vehiclePark.rentVehicle(vehicle, startDate, endDate);
                            break;
                        case 7:
                            System.out.println("Enter id of vehicle");
                            id = scanner.nextInt();
                            vehicle = vehiclePark.findVehicle(id);
                            vehiclePark.dropVehicle(vehicle);
                            break;
                        case 8:
                            System.out.println("Enter id of vehicle");
                            id = scanner.nextInt();
                            vehicle = vehiclePark.findVehicle(id);
                            System.out.println("Amount of load");
                            double amount = scanner.nextDouble();
                            vehiclePark.load(vehicle, amount);
                            break;
                        case 9:
                            System.out.println("QUIT. BYE");
                            vehiclePark.updateVehicleFile();
                            break;
                        default:
                            System.out.println("Wrong choose");
                            break;
                    }
                } while (num != 9);

            } else {
                System.out.println("You are not admin");
            }

        } else {
            System.out.println("Wrong input, start program again!!");
        }
    }
}
