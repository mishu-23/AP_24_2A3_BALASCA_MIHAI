import sun.security.krb5.internal.crypto.Des;

public class Passenger extends Person implements Comparable<Passenger>{
    private Destination destination;

    public Passenger(String name, Destination destination) {
        super(name);
        this.destination = destination;
    }

    public Destination getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "destination=" + destination +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Passenger other) {
        return this.getName().compareTo(other.getName());
    }
}
