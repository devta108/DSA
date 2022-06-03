import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class PrintTargetSumSubset {
    public static class Pair{
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        boolean[][] dp = new boolean[n + 1][tar + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= tar; j++) {
                if (j == 0) {
                    dp[i][0] = true;
                } else {
                    if (dp[i - 1][j] || (j >= arr[i - 1] && dp[i - 1][j - arr[i - 1]])) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(arr.length,tar,""));
        while(!q.isEmpty()){
            Pair rem = q.remove();
//            if(rem.i == 0 )
            if(rem.i == 0 && rem.j == 0){
                System.out.println(rem.psf);
                continue;
            }
            if(dp[rem.i-1][rem.j]) q.add(new Pair(rem.i-1,rem.j,rem.psf));
            if(rem.j>= arr[rem.i-1]){
                if(dp[rem.i-1][rem.j - arr[rem.i-1]]){
                    q.add(new Pair(rem.i-1, rem.j - arr[rem.i-1], rem.psf+arr[rem.i-1]));
                }
            }
        }
        for (boolean[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
    }
}
