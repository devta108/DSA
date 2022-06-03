import java.util.Arrays;
import java.util.Scanner;

/**
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 */
public class URLify {
    public static String urlify(String str, int length){
        String url = "";
        char[] charArr = new char[length] ;
        str = str.trim();
        length = str.length();
        for (int index = 0; index < str.length(); index++) {
            char tmp = str.charAt( index );
            charArr[index] = tmp;
        }
        for (int index = 0; index < charArr.length; index++) {
            if ( charArr[index] != ' ' ) {
                url = url + String.valueOf( (charArr[index]) );
            }
            else{
                url += "%20";
            }
        }
        return url;
    }
    public static void main(String[] args) {
/*
        String str = "Mr John Smith ";
        System.out.println(urlify( str, str.length() ) + urlify( str, str.length() ).length());
*/
    }
}
