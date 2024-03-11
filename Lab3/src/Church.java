public class Church extends Attraction implements Visitable{
    String programStart;
    String programEnd;

    @Override
    public String toString() {
        return "Church{" +
                "programStart='" + programStart + '\'' +
                ", programEnd='" + programEnd + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Church(String name, String description, String programStart, String programEnd) {
        super(name, description);
        this.programStart = programStart;
        this.programEnd = programEnd;
    }

    @Override
    public String getProgramStart() {
        return programStart;
    }

    @Override
    public String getProgramEnd() {
        return programEnd;
    }
}
