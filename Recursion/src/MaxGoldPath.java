import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class MaxGoldPath {
    private static class Pair {
        String psf;
        int i;
        int j;

        public Pair(String psf, int i, int j) {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws Exception {
        int n;
        int m;
        int[][] arr;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
            arr = new int[n][m];

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(str.split(" ")[j]);
                }
            }
        }
        int[][] dp = new int[n][m];

        for(int col =m-1;col>=0;col--){
            for(int row = n-1;row>=0;row--){
                if(col == m-1){
                    dp[row][col] = arr[row][col];
                }
                else{
                    if(row == n-1){
                        dp[row][col] = arr[row][col]+ Math.max(dp[row][col+1],dp[row-1][col+1]);
                    }
                    else if(row == 0){
                        dp[row][col] = arr[row][col]+ Math.max(dp[row][col+1],dp[row+1][col+1]);

                    }
                    else{
                        dp[row][col] = arr[row][col]+ Math.max(dp[row][col+1],Math.max(dp[row+1][col+1],dp[row-1][col+1]));
                    }
                }
            }
        }
        int maxGold = 0;
        for(int i =0;i<n;i++){
            if(dp[i][0]>dp[maxGold][0]) maxGold = i;
        }
        System.out.println(dp[maxGold][0]);
        System.out.print(maxGold);
        Queue<Pair> q;
        q = new ArrayDeque<>();
        q.add(new Pair("",maxGold,0));
        while(!q.isEmpty()){
            Pair remove = q.remove();
            int row = remove.i;
            int col = remove.j;
            if(col == m-1){
                System.out.println(remove.psf);
                continue;
            }
            if(row>0&&row<n){
                if(row<n-1&&dp[row][col+1]>dp[row-1][col+1]&&dp[row][col+1]>dp[row+1][col+1]){
                    q.add(new Pair(remove.psf+"d2 ",row,col+1));
                }
                else if(row<n-1&&(dp[row-1][col+1]>dp[row+1][col+1])&&(dp[row-1][col+1]>dp[row+1][col+1])){
                    q.add(new Pair(remove.psf+"d1 ",row-1,col+1));
                }
                else if(row<n-1 && dp[row+1][col+1]>dp[row][col+1]&&dp[row+1][col+1]>dp[row-1][col+1]){
                    q.add(new Pair(remove.psf+"d3 ",row+1,col+1));
                }
                else if(row<n-1 &&dp[row+1][col+1]==dp[row][col+1]&&dp[row+1][col+1]>dp[row-1][col+1]){
                    q.add(new Pair(remove.psf+"d3 ",row+1,col+1));
                    q.add(new Pair(remove.psf+"d2 ",row,col+1));
                }
                else if(row<n-1 &&dp[row+1][col+1]==dp[row-1][col+1]&&dp[row+1][col+1]>dp[row-1][col+1]){
                    q.add(new Pair(remove.psf+"d3 ",row+1,col+1));
                    q.add(new Pair(remove.psf+"d1 ",row-1,col+1));
                }
                else{
                    q.add(new Pair(remove.psf+"d3 ",row+1,col+1));
                    q.add(new Pair(remove.psf+"d1 ",row-1,col+1));
                    q.add(new Pair(remove.psf+"d2 ",row,col+1));

                }
            }
        }

    }
}
