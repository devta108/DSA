import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class LCSPrint {
    public static class Pair {
        int length;
        int idx;
        String psf;

        Pair(int length, int idx, String psf){
            this.length = length;
            this.idx = idx;
            this.psf = psf;
        }
    }

    public static void solution(int []nums){
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i=1;i<dp.length;i++){
            int lessThanith = 0;
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    lessThanith = Math.max(lessThanith,dp[j]);
                }
            }
            dp[i] = lessThanith +1;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i=0;i<dp.length;i++){
            int num = dp[i];
            if(max < num){
                max = num;
                maxIndex = i;
            }
        }

        System.out.println(max);

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(dp[maxIndex],maxIndex,nums[maxIndex] + ""));
        while(!q.isEmpty()){
            Pair rem = q.remove();
            int si = rem.idx -1;
            int val = nums[rem.idx];
            if(rem.length == 1){
                System.out.println(rem.psf);
                continue;
            }
            for(int j=si;j>=0;j--){
//                System.out.println(j);
                if(dp[j] == rem.length -1 && val>=nums[j]){
                    q.add(new Pair(dp[j], j, nums[j] + " -> "+rem.psf));
                }
            }

        }
    }



    public static void main(String []args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
}
