package 이분탐색;

public class BinarySearch {

    private static int[] arr = {1, 3, 5, 7, 8, 10, 20, 35, 99, 100};
    public static void main(String[] args) {

        System.out.println(binarySearch(50, 0, arr.length - 1));
        
    }

    private static int binarySearch(int key, int low, int high) {
        int mid;

        if (low <= high) {
            mid = (low + high) / 2;

            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                return binarySearch(key, low, mid - 1);
            } else {
                return binarySearch(key, mid + 1, high);
            }
        }
        return -1;
    }
}
