public class Fibonacci {
    public static void main(String[] args) {
         long[] dp = new long[50];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<50;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        System.out.println(dp[49]);
    }
}
