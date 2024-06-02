public class MathOperations {

    @Test
    public static void testAddition() {
        int result = add(2, 3);
        assert result == 5 : "Addition test failed";
    }

    @Test
    public static void testSubtraction() {
        int result = subtract(5, 3);
        assert result == 2 : "Subtraction test failed";
    }

    @Test
    public void testMultiplication() {
        int result = multiply(2, 3);
        assert result == 6 : "Multiplication test failed";
    }

    @Test
    public void testDivision() {
        int result = divide(6, 0);  // This will cause an exception
        assert result == 3 : "Division test failed";
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        return a / b;
    }
}
