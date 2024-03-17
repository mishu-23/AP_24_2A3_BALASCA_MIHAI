import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelPlan {
    private Map<LocalDate, Attraction> plan;

    public TravelPlan() {
        this.plan = new HashMap<>();
    }

    public void add(LocalDate date, Attraction attraction) {
        plan.put(date, attraction);
    }

    public void getTravelPlan() {
        System.out.println("Travel Plan:");
        for (Map.Entry<LocalDate, Attraction> objective : plan.entrySet()) {
            System.out.println(objective.getKey() + ": " + objective.getValue().getName() + ", " + objective.getValue().getDescription() + ", " + objective.getValue().getOpeningHour(objective.getKey()));
        }
    }
}
