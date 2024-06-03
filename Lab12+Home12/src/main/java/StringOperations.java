public class StringOperations {

    @Test
    public void testConcatenate() {
        String result = concatenate("Hello", "World");
        assert result.equals("HelloWorld") : "Concatenate test failed";
    }
    @Test
    public void testLength() {
        int result = stringLength("123456");
        assert result == 5 : "Concatenate test failed";
    }

    @Test
    public void testConcatenateFailure() {
        String result = concatenate("Hello", "World");
        assert result.equals("Hello World") : "Concatenate failure test failed";  // Tgis will fail
    }

    public String concatenate(String a, String b) {
        return a + b;
    }

    public int stringLength(String a) {
        return a.length();
    }
}
