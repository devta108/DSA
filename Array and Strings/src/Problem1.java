/**
 * https://www.geeksforgeeks.org/check-if-a-key-is-present-in-every-segment-of-size-k-in-an-array/
 * Given an array arr[] and size of array is n and one another key x, and give you a segment size k.
 * The task is to find that the key x present in every segment of size k in arr[].
 */

public class Problem1 {
    public static boolean keyCheker(int[] arr, int key, int segmentSize){
        int incri = 1;
        int counter = 0;
        if ( arr.length >= segmentSize ){
            for (int index = 0; index < arr.length; index++) {
                System.out.println(incri);
                if ( arr[index] == key ) {
                    index = segmentSize * incri;
                    incri++;
                    counter++;
                }
            }
            System.out.println(incri);
            if ( incri-1 == Math.ceil( arr.length/segmentSize ) ){
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //    Variables
        int[] arr = { 3, 5, 2, 4, 9, 3, 1, 7, 3, 11, 12, 3};
        int key = 5;
        int size = arr.length;
        int segmentSize = 3;
        boolean result = keyCheker(arr,key,segmentSize);
        System.out.println(result);
    }
}
