import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ProblemsPrime {
    public static void main(String[] args) {
        int n = 3000;
        int p1 = 1, p2 = 1;
        boolean p1c = true, p2c = true;
        ArrayList<Integer> almostPrimes = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++){
            for(int j=2; j <= Math.sqrt( i ); j++){
                if ( i%j == 0 ) {
                    p1 = j;
                    break;
                }
            }
            p2 = i/p1;
                    System.out.println(p1 + " "+ p2);
            if ( p1 != p2 ){
                for (int j = 2; j<= Math.sqrt(p2); j++){
                    if ( p2%j == 0){
                        p2c = false;
                        break;
                    }
                }
                for (int j = 2; j<= Math.sqrt(p1); j++){
                    if ( p1%j == 0){
                        p1c = false;
                        break;
                    }
                }
            }
            if ( p1c == true && p2c == true){
                almostPrimes.add( p1*p2 );
            }
        }
        System.out.println(almostPrimes);
    }
}
