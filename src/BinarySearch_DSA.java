public class BinarySearch_DSA {
    public static int search(int[] arr, int target) {
        // Add left and right variables below
        int left = 0;
        int right = arr.length;
        // Add mid calculation below

        while(right > left) {
            int mid = Math.floorDiv(left + right, 2);
            int midValue = arr[mid];

            if (midValue == target) {
                return mid;
            } // Add else if and else blocks:
            else if (midValue < target) {
                left = mid;
            }
            else {
                right = mid;
            }
        }



        return -1;

    }

    public static void main(String[] args) {
        int[] searchable = {1, 2, 7, 8, 22, 28, 41, 58, 67, 71, 94};
        int target = 41;

        System.out.println(search(searchable, target));
    }
}
