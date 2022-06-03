import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.util.*;

public class SlidingPuzzle {
    static String stringify(int[][] board){
        StringBuilder result = new StringBuilder();
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                result.append(board[i][j]);
            }
        }
        return result.toString();
    }
    static int slidingPuzzle(int[][] board) {
        int[][] finalState = {{1,2,3},{4,5,0}};
        String finalStr = stringify(finalState);
        Set<String> visited = new HashSet<>();
        Queue<int[][]> q = new ArrayDeque<>();
        q.add(board);
        String boardStr = stringify(board);
        visited.add(boardStr);
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        int level = -1;
        while(!q.isEmpty()){
            int size = q.size();

            level++;
            while(size-->0){
                int[][] rem = q.remove();
                String remStr = stringify(rem);
                System.out.println(remStr);
                if(remStr.equals(finalStr)) return level;
                for(int i=0;i<2;i++){
                    for (int j=0;j<3;j++){
                        if(rem[i][j]==0){
                            for(int[] dir:dirs){
                                int newi = i+dir[0];
                                int newj = j+dir[1];
                                if(newi>=0&&newj>=0&&newi<2&&newj<3){
                                    int[][] tempBoard = new int[2][3];
                                    tempBoard[0][0] = rem[0][0];
                                    tempBoard[0][1] = rem[0][1];
                                    tempBoard[0][2] = rem[0][2];
                                    tempBoard[1][0] = rem[1][0];
                                    tempBoard[1][1] = rem[1][1];
                                    tempBoard[1][2] = rem[1][2];
                                    int temp = rem[newi][newj];
                                    tempBoard[newi][newj] = 0;
                                    tempBoard[i][j] = temp;
                                    String tempStr = stringify(tempBoard);
                                    if(!visited.contains(tempStr)){
                                        q.add(tempBoard);
                                        visited.add(tempStr);
                                    }
                                    rem[newi][newj] = temp;
                                    rem[i][j] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(visited);
        return -1;
    }
    public static void main(String[] args) {
        int[][] board = {{1,2,3},{4,0,5}};
//        System.out.println(slidingPuzzle(board));
        String encoded = Base64.getEncoder().encodeToString("wsedrfvgtbhnjm2345678/*-+".getBytes(StandardCharsets.UTF_8));
        byte[] actualByte = Base64.getDecoder().decode(encoded);
        String actualString = new String(actualByte);
        System.out.println(actualString);
        double data = 15/7;
        System.out.println(Math.round(data));
    }
}

