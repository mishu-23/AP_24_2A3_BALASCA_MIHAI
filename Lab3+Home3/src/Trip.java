import javafx.scene.media.AudioTrack;

import javax.smartcardio.ATR;
import java.time.LocalDate;
import java.util.Date;
import java.util.*;

public class Trip{
    private String cityName;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private List<Attraction> attractions;

    public Trip(String cityName, LocalDate startingDate, LocalDate endingDate, List<Attraction> attractions) {
        this.cityName = cityName;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.attractions = attractions;
    }

    public void getVisAndFreeInOrd(LocalDate date) {
        List<Attraction> rightAttractions = new ArrayList<>();
        for(Attraction attraction : attractions) {
            if(!(attraction instanceof Payable)) {
                rightAttractions.add(attraction);
            }
        }
        rightAttractions.sort((Attraction first, Attraction second) -> {
            return first.getOpeningHour(date).compareTo(second.getOpeningHour(date));
        });

        for(Attraction attraction : rightAttractions) {
            System.out.println(attraction.getName() + " " + attraction.getOpeningHour(date));
        }
    }

    @Override
    public String toString() {
        return "Trip{" +
                "cityName='" + cityName + '\'' +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", attractions=" + attractions +
                '}';
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

}
