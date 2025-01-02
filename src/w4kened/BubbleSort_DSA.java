package w4kened;

import java.util.Arrays;

public class BubbleSort_DSA {
    public static int[] bubbleSort(int input[]) {
        boolean swapping = true;

        while (swapping) {
            swapping = false;
            for (int i = 0; i < input.length - 1; i++) {
                if (input[i] > input[i + 1]) {
                    System.out.println(String.format("Swapping pair %d, %d", input[i], input[i+1]));
                    swap(input, i, i + 1);

                    System.out.println(Arrays.toString(input));
                    swapping = true;
                }
            }

        }

        return input;
    }

    private static int[] swap(int arr[], int indexOne, int indexTwo) {
        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;

        return arr;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime(); // ... the code being measured ...
        bubbleSort(new int[] {1,5,4,6,2,3});
        long elapsedNanos = System.nanoTime() - startTime;
        System.out.println( elapsedNanos + " nanoseconds" );

    }
}
