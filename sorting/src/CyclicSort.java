import java.util.ArrayList;
import java.util.Arrays;

public class CyclicSort {
    static void CyclicSort(int[] arr){
        int i =0;
        while(i<arr.length){
            int correctIndex = arr[i] -1;
            if(i != correctIndex)
                Utility.swap(arr,i,correctIndex);
            else{
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,8,1};
        System.out.println(Arrays.toString(arr));
        CyclicSort(arr);
        System.out.println(Arrays.toString(arr));
        ArrayList<Integer> list = new ArrayList<Integer>();
//        if(list.isEmpty()
    }
}
