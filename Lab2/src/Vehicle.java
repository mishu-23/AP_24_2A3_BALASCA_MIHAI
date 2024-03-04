import java.util.Arrays;

public class Vehicle {
    Client tour[];

    public Vehicle(Client[] tour) {
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
