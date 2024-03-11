import java.util.Arrays;

abstract public class Vehicle {
    private String name;
    private Client tour[];

    protected public Vehicle(Client[] tour) {
        this.tour = tour;
    }

    public Client[] getTour() {
        return tour;
    }

    public void setTour(Client[] tour) {
        this.tour = tour;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "tour=" + Arrays.toString(tour) +
                '}';
    }
}
