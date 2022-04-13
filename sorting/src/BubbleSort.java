public class Bubble {

    public static void main(String[] args) {
        int[] arr = {5,8,1,6,8,9,3,4};
        for(int i:arr)
            System.out.print(i + ", ");
        for (int i =0; i< arr.length; i++){
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j]> arr[j+1])
                    InsertionSort.swap(arr,j+1,j);
            }
        }
        System.out.println();
        for(int i:arr)
            System.out.print(i + ", ");
    }
}
