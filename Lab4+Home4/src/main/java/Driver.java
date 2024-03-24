import java.util.ArrayList;
import java.util.List;

public class Driver extends Person implements Comparable<Driver>{
    private int age;
    private List<Destination> destinations = new ArrayList<>();

    private Passenger passenger = null;

    public Driver(String name, int age) {
        super(name);
        this.age = age;
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "age=" + age +
                ", destinations=" + destinations +
                ", passenger=" + retName(passenger) +
                ", name='" + name + '\'' +
                '}';
    }

    private String retName(Passenger passenger) {
        if (passenger != null)
            return '\'' + passenger.getName() + '\'';
        else return null;
    }
    public void addPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public int compareTo(Driver other) {
        return this.age - other.age;
    }

    public String getPassenger() {
        return passenger.getName();
    }
}
