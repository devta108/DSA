import java.util.Arrays;

/**
 * intution is to bubble out largest element at the end of parse
 * time complexity of this algrithm os O(n²)
 */
public class BubbleSort {
    static void bubbleSort(int[] arr){
        for (int i =0; i< arr.length-1; i++){
            boolean swapped = false;
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j]> arr[j+1]) {
                    System.out.println("Value at index "+(j+1)+" is "+arr[j+1]+
                            "  & swapped with index " + (j )+
                            " which is "+arr[j]);
                    swapped = true;
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("Current status of array is "+
                    Arrays.toString(arr));
            if (!swapped)
                break;
        }
    }
    public static void main(String[] args) {
        int[] arr = {13,3,5,7,9,5,4,8,43,345,4678};
//        Utility.printArr(arr);
        System.out.println("Unsorted Array is as : "+ Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Sorted Array is as : "+ Arrays.toString(arr));
//        Utility.printArr(arr);
    }
}
