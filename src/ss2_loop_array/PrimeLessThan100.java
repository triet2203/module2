package ss2_loop_array;

public class PrimeLessThan100 {
    public static void main(String[] args) {
        for (int N = 2; N < 100 ; N++) {
            boolean isPrime = true;
            for (int i = 2; i < Math.sqrt(N); i++) {
                if (N % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(N + " ");
            }
        }
    }
}
