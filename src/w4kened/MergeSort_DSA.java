package w4kened;

import java.util.Arrays;

public class MergeSort_DSA {
    public int[] divide(int[] arr) {
        int length = arr.length;
        if (length <= 1) {
            return arr;
        }
        int mid = Math.floorDiv(length, 2);
        int[] leftArray = Arrays.copyOfRange(arr, 0, mid);
        int[] rightArray = Arrays.copyOfRange(arr, mid, length);
        System.out.println("divided left= "+Arrays.toString(leftArray));
        System.out.println("divided right= "+Arrays.toString(rightArray));

        int[] lDividedArray = divide(leftArray);
        int[] rDividedArray = divide(rightArray);

        return mergeAndSort(lDividedArray, rDividedArray);
    }

    public int[] mergeAndSort(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int leftPos = 0;
        int rightPos = 0;
        int curIndex = 0;

        while (left.length > leftPos &&
                right.length > rightPos) {
            System.out.println("left comparing "+Arrays.toString(left));
            System.out.println("right comparing "+Arrays.toString(right));

            if (left[leftPos] < right[rightPos]) {
                merged[curIndex++] = left[leftPos++];
                System.out.println("from left to merge "+Arrays.toString(merged));
            }
            else {
                merged[curIndex++] = right[rightPos++];
                System.out.println("from right to merge "+Arrays.toString(merged));
            }

            continue;
        }

        System.arraycopy(left, leftPos, merged, curIndex,
                left.length - leftPos);
        System.out.println("arraycopy from remaining left to merged "+Arrays.toString(merged));

        System.arraycopy(right, rightPos, merged, curIndex,
                right.length - rightPos);
        System.out.println("arraycopy from remaining right to merged "+Arrays.toString(merged));

        return merged;
    }


    public static void main (String[] args) {
        int[] inputArr = {3, 5, 2, 90, 4, 7};
        MergeSort_DSA sorter = new MergeSort_DSA();
        System.out.println("input "+ Arrays.toString(inputArr));

        long startTime = System.nanoTime(); // ... the code being measured ...
        System.out.println(Arrays.toString(sorter.divide(inputArr)));
        long elapsedNanos = System.nanoTime() - startTime;

        System.out.println( elapsedNanos + " nanoseconds" );
    }
}
