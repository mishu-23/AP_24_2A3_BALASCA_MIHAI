public class Statue extends Attraction implements Visitable{
    String programStart;
    String programEnd;

    public Statue(String name, String description, String programStart, String programEnd) {
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

    @Override
    public String toString() {
        return "Statue{" +
                "programStart='" + programStart + '\'' +
                ", programEnd='" + programEnd + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
