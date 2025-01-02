package w4kened.misc;
import java.util.*;
public class SieveOfEratosthenes_DSA {
     Integer[] sieveOfEratosthenes(int n) {
        boolean[] primes = new boolean[n + 1];

        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }
        primes[0] = false;
        primes[1] = false;
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (primes[i] == true) {
                for (int j = i * 2; j <= n; j = j + i) {
                    primes[j] = false;
                }
            }
        }
        for (int i = 2; i <=n; i++) {
            if (primes[i]) {
                numbers.add(i);
            }
        }
        Integer ans[] = new Integer[numbers.size()];
        ans = numbers.toArray(ans);
        return ans;
    }

    public static void main(String[] args) {
        int n = 7;
        SieveOfEratosthenes_DSA g = new SieveOfEratosthenes_DSA();
        System.out.println(
                Arrays.toString(
                        g.sieveOfEratosthenes(n)
                )
        );
        // should return [2, 3, 5, 7]
    }
}
