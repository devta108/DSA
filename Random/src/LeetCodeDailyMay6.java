import java.util.Scanner;

public class LeetCodeDailyMay6 {
    static int isPossibleToTrim(String str,int k){
        int occurence = 1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i) == str.charAt(i-1) && occurence !=k) occurence++;
            else{
                occurence = 1;
            }
            if(occurence == k){
                return i-k+1;
            }
        }

        return -1;
    }
    static String removeDuplicates(String s, int k) {

        while(true){
            int idx = isPossibleToTrim(s,k);
            if(idx != -1){
                String left = s.substring(0,idx);
                String right = s.substring(idx+k);
                s = left + right;
                // break;
            }
            else break;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        System.out.println(removeDuplicates(str,n));
    }
}
