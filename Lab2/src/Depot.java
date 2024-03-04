public class Depot {
    Vehicle vehicle;

    public Depot(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Depot{" +
                "vehicle=" + vehicle +
                '}';
    }
}
