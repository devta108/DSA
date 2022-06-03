import java.math.BigInteger;

public class Sqrt {
    public static int mySqrt(int x) {
        int start = 1;
        int end = x;
        int ans = 1;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            System.out.print( mid + ", " );
            if ( mid * mid < x ) {
                ans = (int) mid;
                start = (int) (mid + 1);
            } else if ( mid * mid > x )
                end = (int) (mid - 1);
            else
                return (int) mid;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println( mySqrt( 2147395599 ) );
    }
}
