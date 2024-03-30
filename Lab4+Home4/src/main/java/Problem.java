import sun.security.krb5.internal.crypto.Des;

import java.util.*;

public class Problem {
    public static void main(String[] args) {
        int count = 10;
        Person[] group = new Person[count];
        List<Driver> drivers = new LinkedList<>();
        Set<Passenger> passengers = new TreeSet<>();
        Carpool carpool = new Carpool(group, drivers, passengers);
        carpool.randomGroup(count);
        carpool.sortDriversAndPassengers();
        carpool.getAllDestinations();
        carpool.getOrderedDrivers();
        carpool.getOrderedPassengers();

        for(Driver driver : carpool.getDrivers()) {
            List<Destination> driverDestinations = driver.getDestinations();
            Passenger assignedPassenger = null;
            for (Passenger passenger : carpool.getPassengers()) {
                if (driverDestinations.contains(passenger.getDestination())) {
                    assignedPassenger = passenger;
                    break;
                }
            }
            if(assignedPassenger != null) {
                driver.addPassenger(assignedPassenger);
                carpool.getPassengers().remove(assignedPassenger);
            }
        }


















        System.out.println("AFTER ASSIGNING PASSENGERS:");
        carpool.getOrderedDrivers();
        carpool.getOrderedPassengers();
    }
}
