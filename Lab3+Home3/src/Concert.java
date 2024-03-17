import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class Concert extends Attraction implements Payable {
    private int fee;

    public Concert(String name, String description, int fee) {
        super(name, description);
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "visitingTimeTable=" + visitingTimeTable +
                ", fee=" + fee +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


    @Override
    public int getFee() {
        return fee;
    }
}
