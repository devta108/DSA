import java.util.Scanner;

public class CrossWord {
    public static void solution(char[][] arr, String[] words, int vidx) {

        if(vidx == words.length){
            print(arr);
            return;
        }
        String word = words[vidx];
        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] == '-'||arr[i][j]==word.charAt(0)){
                    if(canPlaceHorizontally(arr,word,i,j)){
                        boolean[] placement = placeHorizontally(arr,word,i,j);
                        solution(arr,words,vidx+1);
                        unplaceWordHorizontally(arr,word,i,j,placement);
                    }
                    if(canPlaceVertically(arr,word,i,j)){
                        boolean[] placement = placeVertically(arr,word,i,j);
                        solution(arr,words,vidx+1);
                        unplaceWordVertically (arr,word,i,j,placement);
                    }
                }
            }
        }
    }
    static boolean canPlaceHorizontally(char[][] arr,String word,int row,int col){
        int count = 0;
        while(row!= arr.length&& col!= arr[0].length&&arr[row][col]!='+'&&count <word.length()){
            if(arr[row][col] !='-' && arr[row][col] != word.charAt(count)) return false;
//            if(arr[row][col] != '-' && arr[row][col] != word.charAt(count)) return false;
            count++;
            col++;
        }
        return (count==word.length());
    }
    static boolean[] placeHorizontally(char[][] arr,String word,int row,int col){
        boolean[] result = new boolean[word.length()];
        for (int i = 0;i<word.length();i++){
            if(arr[row][col+i] != '-') {
                result[i] = true;
                continue;
            }
            arr[row][col+i] = word.charAt(i);
        }
        return result;
    }
    static void unplaceWordHorizontally(char[][] arr,String word,int row,int col,boolean[] placement){
         for(int i = 0;i<word.length();i++){
             if(placement[i]) continue;
             else{
                 arr[row][col+i] = '-';
             }
         }
    }
    static boolean canPlaceVertically(char[][] arr,String word,int row,int col){
        int count = 0;
        while(row!= arr.length&& col!= arr[0].length&&arr[row][col]!='+'&&count<word.length()){
            if( arr[row][col] !='-' && arr[row][col] != word.charAt(count)) return false;
            count++;
            row++;
        }
        return (count==word.length());
    }
    static boolean[] placeVertically(char[][] arr,String word,int row,int col){
        boolean[] result = new boolean[word.length()];
        for (int i = 0;i<word.length();i++){
            if(arr[row+i][col] != '-') {
                result[i] = true;
                continue;
            }
            arr[row+i][col] = word.charAt(i);
        }
        return result;
    }
    static void unplaceWordVertically(char[][] arr,String word,int row,int col,boolean[] placement){
        for(int i = 0;i<word.length();i++){
            if(placement[i]) continue;
            else{
                arr[row+i][col] = '-';
            }
        }
    }


    public static void print(char[][] arr) {
        for (int i = 0 ; i < arr.length; i++) {
            for (int j = 0 ; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0 ; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0 ; i  < words.length; i++) {
            words[i] = scn.next();
        }
        solution(arr, words, 0);
//        print(arr);
    }
}
