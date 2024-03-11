public class Concert extends Attraction implements Payable{
    private int fee;

    @Override
    public String toString() {
        return "Concert{" +
                "fee=" + fee +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Concert(String name, String description, int fee) {
        super(name, description);
        this.fee = fee;
    }

    @Override
    public int getFee() {
        return fee;
    }
}
