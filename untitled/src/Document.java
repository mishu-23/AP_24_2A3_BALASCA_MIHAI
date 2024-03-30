public record Document(String name, String format) {
    @Override
    public String toString() {
        return "Document{" +
                "name='" + name + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
