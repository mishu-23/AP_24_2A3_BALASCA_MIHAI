public class Depot {
    private String name;
    private Vehicle vehicle;

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

    @Override
    public boolean equals(Object object) {
        if(this == object)
            return true;
        if(!(object instanceof Complex))
            return false;
        Depot depot = (Depot) object;
        return
    }
}
