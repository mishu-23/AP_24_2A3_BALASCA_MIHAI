public abstract class Command {
    String message;

    public Command(String message) {
        this.message = message;
    }

    public String execute(){
        return message;
    }
}
