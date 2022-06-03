import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

public class LeftShift {

    static int[] getDiff(int mask1, int mask2){
        int mask = 1;
        int greater = (mask1<mask2)? mask2:mask1;
        int setBits1 = 0;
        int setBits2 = 0;
        int diff = 0;
        while(mask<greater){
            System.out.println(mask);
            if(((mask1&mask) >0 )&& ((mask2&mask) >0) ){setBits1++; setBits2++;}
            else if(((mask1&mask) >0) && ((mask2&mask) ==0 )){diff++; setBits1++;}
            else if(((mask1&mask) == 0) && ((mask2&mask) >0) ){diff++; setBits2++;}
            mask = mask << 1;
        }
        return new int[]{diff,setBits1,setBits2};
    }
    public int[] groupStrings(String[] words) {
        int[] maskChars = new int[26];
        for(int i=0;i<26;i++){
            maskChars[i] = 1<<i;
        }
        int[] maskWords = new int[words.length];
        for(int i =0;i<words.length;i++){
            String word = words[i];
            int mask = 0;
            for(char ch: word.toCharArray()){
                mask |= maskChars[ch-'a'];
            }
            maskWords[i] = mask;
        }
        int[] get = getDiff(123,885);
        return new int[]{1,3};
    }
    public static void main(String[] args) {
        int[] temp = getDiff(12552,785582);
        System.out.println(Arrays.toString(temp));
        HashSet<Integer> counted = new HashSet<>();
        
    }
}
