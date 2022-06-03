import java.sql.Array;
import java.util.Arrays;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if you
 * cannot use additional data structures?
 */

public class IsUnique {
    public static boolean isUnique(String testString){
        int[] charCounter = new int[256];
        Arrays.fill( charCounter, 0 );
//        System.out.println(testString.length());
        for (int index = 0; index < testString.length(); index++) {
            int assciiCode = testString.charAt( index );
            charCounter[assciiCode] += 1;
            if ( charCounter[assciiCode] >1 ){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String testString = "qwertyuiopasdfghjklzxcvbnma";
        System.out.println(isUnique( testString ));
        
    }
}
