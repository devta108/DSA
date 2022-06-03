import java.util.Scanner;

public class LexicographicalPrint {
    static void printAllStartsWith(int n, int upto){
        if(n>upto) return;
        System.out.println(n);
        for(int i =0;i<10;i++){
            String prefix = ""+n+i;
            int nextPreFix = Integer.parseInt(prefix);
            // System.out.println(nextPrefix);
            printAllStartsWith(nextPreFix,upto);
        }
    }
    public static void main(String[] args) {
        int n;
        try (Scanner scn = new Scanner(System.in)) {
            n = scn.nextInt();
        }
        for(int i =1;i<=9;i++){
            printAllStartsWith(i,n);
        }
    }
}
