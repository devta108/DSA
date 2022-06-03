import java.util.Arrays;

public class MergeSort {
    static int[] mergeSort(int[] arr,int start,int end){
//        int[] arr1 = mergeSort(arr,start,end);
        if(start == end){
            int[] res = new int[2];
            res[0] = arr[start];
            res[1] = Integer.MAX_VALUE;
            return res;
        }
//        start = 0;
        int mid = (start+end)/2;
//        end = arr.length;
        int[] arr1 = mergeSort(arr,start,mid);
        int[] arr2 = mergeSort(arr,mid+1,end);

        return Utility.merge(arr1,arr2);
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,21,1};
        System.out.println(Arrays.toString(mergeSort(arr,0,arr.length-1)));
    }
}
