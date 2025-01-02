package w4kened.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Memoization_DSA {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        AtomicInteger calls = new AtomicInteger(0);

        System.out.println(fibMemo(5, map, calls));
        System.out.println("fibMemo: " + calls.get());

        // Reset calls for the non-memoized version
        calls.set(0);
        System.out.println(fibNoMemo(5, calls));
        System.out.println("fibNoMemo: " + calls.get());
    }

    public static int fibMemo(int n, Map<Integer, Integer> map, AtomicInteger calls) {
        calls.incrementAndGet();
        if (n == 0 || n == 1) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int currentVal = fibMemo(n - 1, map, calls) + fibMemo(n - 2, map, calls);
            map.put(n, currentVal);
            return currentVal;
        }
    }

    public static int fibNoMemo(int n, AtomicInteger calls) {
        calls.incrementAndGet();
        if (n == 0 || n == 1) {
            return n;
        }
        return fibNoMemo(n - 1, calls) + fibNoMemo(n - 2, calls);
    }
}
