public class Main {
    public enum Type{
        regular,
        premium
    }
    public static void main(String[] args) {
        Client[] tour = new Client[4];
        for( int i = 0; i < 4; i++ ) {
            tour[i] = new Client("client" + i, "10:00 - 14:00");
        }
        Vehicle vehicle = new Vehicle(tour);
        Depot depot = new Depot(vehicle);
        for(int i = 0; i < tour.length; i++) {
            System.out.println(tour[i]);
        }
        System.out.println();
        System.out.println(vehicle);
        System.out.println();
        System.out.println(depot);

    }
}
