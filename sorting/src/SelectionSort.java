import java.util.Arrays;

public class SelectionSort {
    static int maxElement(int[] arr, int index){
        int max = 0;
        for(int i =0; i<=index; i++){
            if (arr[max]<arr[i])
                max= i;
        }
        return max;
    }
    static void selectionSort(int[] arr){
            for (int i = arr.length-1; i>0;i--){
                int max = maxElement(arr,i);
                System.out.println("Element at index "+max+" is "+arr[max]+
                        "  & swapped with index " + (i )+
                        " which is "+arr[i]);
                int temp = arr[max];
                arr[max] = arr[i];
                arr[i] = temp;
                System.out.println("Current status of array : "+ Arrays.toString(arr));
        }
    }
    public static void main(String[] args) {
        int[] arr = {13,3,5,7,9,5,4,8,43,345,4678};
        System.out.println("Unsorted array is as : "+Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Sorted array is as : "+Arrays.toString(arr));
    }
}
