import com.github.javafaker.Faker;
public abstract class Person {
    Faker faker = new Faker();
    protected String name = faker.name().firstName();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
