import java.util.Arrays;
import java.util.Scanner;

public class GrayCode {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String str = "/a/b/c///dferhg/e/../../../../";
        String[] split = str.split("/");
        System.out.println(split[8]+" "+split[8].length()+" "+(split[8].equals("..")));
        System.out.println(Arrays.toString(split));
        StringBuilder result = new StringBuilder();
        result.append("sharma");
        result.insert(0,"nishek ");
        System.out.println();
        System.out.println(result.toString());

    }
}
