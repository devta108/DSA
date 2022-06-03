import java.util.Arrays;
import java.util.PriorityQueue;

public class Weekly289 {
    public static int largestInteger(int num) {
        String str = ""+num;
        char[] arr = str.toCharArray();
        for(int i=0;i<arr.length;i++){
            int max = i;
            if((arr[i]-'0' )%2 == 0){
                for(int j=i+1;j<arr.length;j++){
                    if((arr[j]-'0' )%2 == 0 && arr[j]>arr[max]) max = j;
                }
            }
            else {
                for (int j = i + 1; j < arr.length; j++) {
                    if ((arr[j] - '0') % 2 == 1 && arr[j] > arr[max]) max = j;
                }
            }
            if(max !=i){
                char temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }
        int result = 0;
        for(char ch:arr){
            result = result*10 + (ch - '0');
        }
        return result;
    }
    public static int maximumProduct(int[] nums, int k) {
        int MOD = 1_000_000_007;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num:nums){
            minHeap.add(num);
        }
        while(k!=0){
            int rem = minHeap.remove();
            minHeap.add(rem+1);
            k--;
        }
        long result = 1;
        while(!minHeap.isEmpty()){
            int rem = minHeap.remove();
            result = (result*rem)%MOD;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        largestInteger(1334566);
        int[] nums = {6,3,3,2};
        System.out.println(maximumProduct(nums,2));
//        System.out.println(largestInteger(1234575));
    }
}
