public class Client {
    String name;
    String timeInterval;

    public Client(String name, String timeInterval) {
        this.name = name;
        this.timeInterval = timeInterval;
    }

    public String getName() {
        return name;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", timeInterval='" + timeInterval + '\'' +
                '}';
    }
}
