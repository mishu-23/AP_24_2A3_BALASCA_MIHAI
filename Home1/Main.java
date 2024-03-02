//Balasca Mihai 2A3
public class Main {
    public static int kreductibil(int x) {
        if( x < 0) {
            return -1;
        }
        if( x < 10) {
            return x;
        }

        int newX = 0;
        int rest = x;
        while (rest > 0) {
            newX += (rest % 10) * (rest % 10);
            rest /= 10;
        }
        return kreductibil(newX);
    }

    public static void verifInterval(int a, int b, int k) {
        String sir="";
        if(a < b) {
            for( int i = a; i <= b; i++) {
                if(kreductibil(i) == k) {
                    sir = sir + ' ' + i;
                }
            }
            System.out.println(sir);
        } else {
            System.out.println("Error: a > b");
        }
    }
    public static void main(String[] args) {
        long start = System.nanoTime();
        int x = 123;
        System.out.println("x = " + kreductibil(x));

        verifInterval(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));

        long end = System.nanoTime();
        long timeNano = end - start;
        double timeMillis = timeNano / 1_000_000.0;
        System.out.println("Nanosecunde: " + timeNano);
        System.out.println("Milisecunde: " + timeMillis);
    }
}
