import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.Buffer;
import java.util.*;

public class NumberOfDistinctIsland {
    public static void main(String[] args) throws NumberFormatException, IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(numDistinctIslands(arr));

    }

    public static StringBuilder psf = new StringBuilder();

    public static int numDistinctIslands(int[][] arr) {
        HashSet<String> set = new HashSet<>();

        for(int i = 0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] == 1){
                    psf= new StringBuilder();
                    psf.append('x');
                    dfs(arr,i,j);
                    String temp = psf.toString();
                    set.add(temp);
                }
            }
        }
        return set.size();
    }
    static int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    static void dfs(int[][] arr,int row, int col) {

        arr[row][col] = 0;
        if(row-1>=0 && arr[row-1][col] == 1){
            psf.append('u');
            dfs(arr,row-1,col);

        }
        if(col+1<arr[0].length && arr[row][col+1] == 1){
            psf.append('r');
            dfs(arr,row,col+1);

        }
        if(row+1<arr.length && arr[row+1][col]==1){
            psf.append('d');
            dfs(arr,row+1,col);

        }
        if(col-1>=0 && arr[row][col-1]==1){
            psf.append('l');
            dfs(arr, row, col - 1);

        }
        ArrayList<Integer>[] hash;
        hash = new ArrayList[1000];
        psf.append('b');
        String str = "dfghjkl";
        InputStreamReader ir = new InputStreamReader(System.in);
        Scanner sc = new Scanner(System.in);
        String string  = sc.nextLine();
        String[] part = string.split(" ");
        int[][] intervals = new int[10][10];
        intervals[0][0] = Integer.parseInt(part[0]);
        int nearest = (int)(Math.sqrt(10));
        Arrays.sort(intervals,(o1,o2) ->{
            boolean b = o1[0] < o2[0];
            if(b) return 0;
            else return 1;
        });
    }
}
