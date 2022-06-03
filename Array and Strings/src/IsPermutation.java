import java.util.Arrays;
import java.util.Scanner;

/**
 * Given two strings, write a method to decide if one is a permutation of the
 * other.
 */
public class IsPermutation {
    public static boolean isPermutation(String str1, String str2) {
        str1.toUpperCase();
        str2.toUpperCase();
        int[] asciiHashStr1 = new int[128], asciiHashStr2 = new int[128];
        Arrays.fill( asciiHashStr1, 0 );
        Arrays.fill( asciiHashStr2, 0 );
        for (int index = 0; index < str1.length(); index++) {
            int char1 = str1.charAt( index );
            if ( char1 != 32 ) {
                asciiHashStr1[char1] += 1;
            }
        }
        for (int index = 0; index < str2.length(); index++) {
            int char1 = str2.charAt( index );
            if ( char1 != 32 ) {
                asciiHashStr2[char1] += 1;
            }
        }
        return Arrays.equals( asciiHashStr1, asciiHashStr2 );
    }
    public static void main(String[] args) {
        String checkStr1 = "   123456789 0  ";
        String checkStr2 = "12 3 4567890";
        Scanner scanner = new Scanner( System.in );
                String s3 = scanner.next();
        System.out.println(isPermutation( checkStr1,checkStr2 ));

    }
}
