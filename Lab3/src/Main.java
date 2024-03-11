import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Attraction> attractions = new ArrayList<>();
        Church church = new Church("biserica1", "descriere1", "8", "16");
        Statue statue = new Statue("statuie1", "descriere1", "8", "16");
        Concert concert = new Concert("concert1", "descriere1", 20);

        attractions.add(church);
        attractions.add(statue);
        attractions.add(concert);

        Trip trip = new Trip("Iasi", 8, 20, attractions);

        System.out.println(trip);
    }
}
