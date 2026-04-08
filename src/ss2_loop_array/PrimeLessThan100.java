package ss2_loop_array;

public class PrimeLessThan100 {
    public static void main(String[] args) {
        for (int N = 2; N < 100; N++) {
            if (isPrime(N)) {
                System.out.print(N + " ");
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
