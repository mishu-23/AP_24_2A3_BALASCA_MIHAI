import javafx.fxml.LoadException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Attraction> attractions = new ArrayList<>();
        Church church1 = new Church("biserica1", "foarte faina");
        church1.addVisitingTimeInTable(LocalDate.now().plusDays(1), LocalTime.of(9, 0), LocalTime.of(21, 0));
        church1.addVisitingTimeInTable(LocalDate.now().plusDays(2), LocalTime.of(9, 0), LocalTime.of(21, 0));
        church1.addVisitingTimeInTable(LocalDate.now().plusDays(3), LocalTime.of(9, 0), LocalTime.of(21, 0));

        Church church2 = new Church("biserica2", "foarte faina");
        church2.addVisitingTimeInTable(LocalDate.now().plusDays(1), LocalTime.of(6, 0), LocalTime.of(22, 0));

        Statue statue = new Statue("statuie", "foarte foarte faina");
        statue.addVisitingTimeInTable(LocalDate.now(), LocalTime.of(10, 0), LocalTime.of(18, 0));
        Concert concert = new Concert("concert", "cel mai fain", 20);
        concert.addVisitingTimeInTable(LocalDate.now().plusDays(5), LocalTime.of(20, 0), LocalTime.of(23, 0));


        attractions.add(church1);
        attractions.add(church2);
        attractions.add(statue);
        attractions.add(concert);

        Trip trip = new Trip("Iasi", LocalDate.now(), LocalDate.now().plusDays(8), attractions);

        System.out.println("Attractions visitable and free, in order: ");
        trip.getVisAndFreeInOrd(LocalDate.now().plusDays(1));

        TravelPlan travelPlan = new TravelPlan();

        travelPlan.add(LocalDate.now().plusDays(1), church1);
        travelPlan.add(LocalDate.now(), statue);
        travelPlan.add(LocalDate.now().plusDays(5), concert);

        travelPlan.getTravelPlan();
    }
}
