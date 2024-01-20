package kata5;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class LargestPrimeCommand implements Command{
    @Override
    public Output execute(Input input) {
        try {
            return outputOf(largestPrime(input.get("number")));
        } catch (Exception e) {
            return outpuException();
        }
    }

    private Output outpuException() {
        return new Output() {
            @Override
            public String result() {
                return null;
            }

            @Override
            public int response() {
                return 403;
            }
        };
    }

    private Output outputOf(String result){
        return new Output() {
            @Override
            public String result() {
                return result;
            }

            @Override
            public int response() {
                return 200;
            }
        };
    }

    private String largestPrime(String number) {
        return valueOf(largestPrime(parseInt(number)));
    }

    private static int largestPrime(int number) {
        if (number <= 1) return -1;
        if (number == 2) return 2;
        if (number % 2 == 0) number--;

        for (int i = number; i > 1 ; i-=2) {
            if (isPrime(i)) return i;
        }
        return -1;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(number) ; i+=2) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
