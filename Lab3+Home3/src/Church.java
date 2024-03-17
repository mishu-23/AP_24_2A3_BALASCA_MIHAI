import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Church extends Attraction{

    public Church(String name, String description) {
        super(name, description);
    }

    @Override
    public String toString() {
        return "Church{" +
                "visitingTimeTable=" + visitingTimeTable +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
