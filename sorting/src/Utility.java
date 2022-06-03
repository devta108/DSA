public class Utility {
    static int[] swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return arr;
    }
    static int maxElement(int[] arr, int index){
        int max = 0;
        for(int i =0; i<=index; i++){
            if (arr[max]<arr[i])
                max= i;
        }
        return max;
    }
    static int[] merge(int[] arr1,int[] arr2){
        int[] merged = new int[arr1.length+ arr2.length-1];
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < merged.length; i++) {
            if (arr1[idx1] < arr2[idx2]) {
                merged[i] = arr1[idx1];
                idx1++;
            }
            else{
                merged[i] = arr2[idx2];
                idx2++;
            }
        }
        return merged;
    }
    public static void printArr(int[] arr){
        for(int i: arr)
            System.out.print(i + ", ");
    }
}
