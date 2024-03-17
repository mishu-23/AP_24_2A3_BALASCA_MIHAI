import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
import java.util.HashMap;
public class Statue extends Attraction{

    public Statue(String name, String description) {
        super(name, description);
    }

    @Override
    public String toString() {
        return "Statue{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", visitingTimeTable=" + visitingTimeTable +
                '}';
    }
}
