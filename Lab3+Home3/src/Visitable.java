import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public interface Visitable {
    Map<LocalDate, Pair<LocalTime, LocalTime>> getTimeTable();
    default LocalTime getOpeningHour(LocalDate date) {
        Map<LocalDate, Pair<LocalTime, LocalTime>> timeTable = getTimeTable();
        return timeTable.getOrDefault(date, new Pair<>(LocalTime.MIN, LocalTime.MIN)).getKey();
    }
    public class Pair<T, S> {
        private final T key;
        private final S val;

        public Pair(T key, S val) {
            this.key = key;
            this.val = val;
        }

        public T getKey() {
            return key;
        }

        public S getVal() {
            return val;
        }
    }
}
