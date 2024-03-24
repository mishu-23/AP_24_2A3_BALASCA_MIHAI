import sun.awt.image.ImageWatched;
import sun.reflect.generics.tree.Tree;
import com.github.javafaker.Faker;
import sun.security.krb5.internal.crypto.Des;

import java.util.*;
import java.util.stream.Collectors;

public class Carpool {
    Faker faker = new Faker();
    private List<Destination> allDestinations = randomDestinations();
    private Person[] group;
    private List<Driver> drivers;
    private Set<Passenger> passengers;

    public Carpool(Person[] group, List<Driver> drivers, Set<Passenger> passengers) {
        this.group = group;
        this.drivers = drivers;
        this.passengers = passengers;
    }

    private void sortDriversFromGroup(Person[] group) {
        drivers = Arrays.stream(group)
                .filter(person -> person instanceof Driver)
                .map(person -> (Driver) person)
                .collect(Collectors.toList());
    }

    private void sortPassengersFromGroup(Person[] group) {
        passengers = Arrays.stream(group)
                .filter(person -> person instanceof Passenger)
                .map(person -> (Passenger) person)
                .collect(Collectors.toSet());;
    }

    public void sortDriversAndPassengers (){
        this.sortDriversFromGroup(group);
        this.sortPassengersFromGroup(group);
    }

    private List<Destination> randomDestinations() {
        List<Destination> destinations = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            destinations.add(new Destination(faker.address().cityName()));
        return destinations;
    }
    public void randomGroup(int count) {
        Random random = new Random();
        group = new Person[count];
        for (int i = 0; i < count; i++) {
            if (random.nextBoolean()) {
                Driver driver = new Driver(faker.name().firstName(), random.nextInt(60) + 18);
                for(int j = 0; j < 5; j++) {
                    driver.addDestination(allDestinations.get(random.nextInt(5)));
                }
                group[i] = driver;
            } else {
                group[i] = new Passenger(faker.name().firstName(), allDestinations.get(random.nextInt(5)));
            }
        }
    }

    public void getOrderedDrivers () {
        LinkedList<Driver> orderedDrivers = drivers.stream()
                .sorted(Driver::compareTo)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("Ordered drivers by age:");
        orderedDrivers.forEach(System.out::println);
    }
    public void getOrderedPassengers () {
        TreeSet<Passenger> orderedPassengers = passengers.stream()
                .sorted(Passenger::compareTo)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("Ordered passengers by name:");
        orderedPassengers.forEach(System.out::println);
    }

    public void getAllDestinations () {
        System.out.println("All destinations:");
        allDestinations.forEach(System.out::println);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }
}
