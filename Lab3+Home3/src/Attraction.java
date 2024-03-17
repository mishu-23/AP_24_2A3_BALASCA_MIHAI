import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public abstract class Attraction implements Visitable, Comparable<Attraction>{
    protected String name;
    protected String description;
    protected Map<LocalDate, Pair<LocalTime, LocalTime>> visitingTimeTable = new HashMap<>();

    protected Attraction(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<LocalDate, Pair<LocalTime, LocalTime>> getVisitingTimeTable() {
        return visitingTimeTable;
    }

    public void setName(String name) { this.name = name; }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addVisitingTimeInTable(LocalDate date, LocalTime open, LocalTime close) {
        visitingTimeTable.put(date, new Pair<>(open, close));
    }

    @Override
    public Map<LocalDate, Pair<LocalTime, LocalTime>> getTimeTable() {
        return visitingTimeTable;
    }


    @Override
    public int compareTo(Attraction other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", visitingTimeTable=" + visitingTimeTable +
                '}';
    }
}

