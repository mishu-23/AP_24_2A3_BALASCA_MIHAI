public class Destination {
    private String cityName;
    public Destination(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return '\'' + cityName + '\'';
    }
}
