//Balasca Mihai 2A3
public class lab1 {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1000000);

        int res = n * 3;
        res += Integer.parseInt("10101", 2);
        res += Integer.parseInt("FF", 16);
        res *= 6;

        //System.out.println(Integer.parseInt("FF", 16));

        int sum = 0;
        do {
            while( res != 0 ) {
                sum += res % 10;
                res /= 10;
            }
            res = sum;
            sum = 0;
        } while(res > 9);


        //System.out.println(res);
        System.out.println("Willy-nilly, this semester I will learn " + languages[res]);
    }
}
