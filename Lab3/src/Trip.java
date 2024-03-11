import java.util.ArrayList;
import java.util.List;

public class Trip{
    private String cityName;
    private int startingDate;
    private int endingDate;
    private List<Attraction> attracions = new ArrayList<>();

    public Trip(String cityName, int startingDate, int endingDate, List<Attraction> attracions) {
        this.cityName = cityName;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.attracions = attracions;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "cityName='" + cityName + '\'' +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", attracions=" + attracions +
                '}';
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(int startingDate) {
        this.startingDate = startingDate;
    }

    public int getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(int endingDate) {
        this.endingDate = endingDate;
    }

    public List<Attraction> getAttracions() {
        return attracions;
    }

    public void setAttracions(List<Attraction> attracions) {
        this.attracions = attracions;
    }
}
