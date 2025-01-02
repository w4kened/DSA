package w4kened;

import java.util.Arrays;

public class QuickSort_DSA {
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[Math.floorDiv(left + right, 2)];
        while (left < right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }

        return left;
    }
    public int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partition =  partition(arr, left, right);
            if (left < partition) {
                quickSort(arr, left, partition);
            }
            if (partition + 1 < right) {
                quickSort(arr, partition + 1, right);
            }
        }
        return arr;
    }
    private static int[] swap(int arr[], int indexOne, int indexTwo) {
        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;

        return arr;
    }
    public static void main(String[] args) {
        QuickSort_DSA quickSortDsa = new QuickSort_DSA();


        long startTime = System.nanoTime(); // ... the code being measured ...
        int[] sortedArr = quickSortDsa.quickSort(new int[] {1,5,4,6,2,3}, 0, 5);
        long elapsedNanos = System.nanoTime() - startTime;
        System.out.println("->"+Arrays.toString(sortedArr));
        System.out.println( elapsedNanos + " nanoseconds" );

    }
}
