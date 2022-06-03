import java.lang.reflect.Array;
import java.util.Arrays;

public class Prime {
    // find out the all the primes between 1 to n
    // finding out the number is prime or not
    /**
     * Bruteforce method is to divide the number till n/2 and find out weather it is prime or not
     * it gives complexity of O(n)
     *
     * Optimised method is to check weather number is divisible till it's root or not,
     * say we need to find out weather n is prime or not
     * we will check till root(n) because only root(n) is the largest individual number to be checked\
     * after that all the numbers will be multiple of numbers till root(n).
     */
    // CODE
    public static boolean isPrime(int n){
        if(n ==1){
            return false;
        }
        for (int i = 2; i < Math.sqrt( n ) ; i++) {
            if ( n%i == 0 ){
                System.out.println(i);
                return false;
            }
        }
        return true;
        // Complexity of this program is O(root(n))
    }

    /**
     *Now we found out optimised method to evaluate the number is prime or not,
     * to solve the problem of 'Finding the all primes till 1 - N'
     * Brute force ----> check numbers till n it is prime or not, it'll solve the problem
     * but is complexity will be O(n*root(n))
     *
     * algorithm
     * make array of size n and fill it with 1
     * start from 2, mark all the subsequent index which is multiple of 2's value as 0 from 1
     */
    //CODE
    public static void sieve(int n){
        boolean[] arr = new boolean[n];
        Arrays.fill( arr, true );
        arr[1] = false;
//        System.out.println(arr.length);
        for (int i = 2; i < Math.sqrt( n ) ; i++) {
            if ( arr[i]== true ){
                for (int j = 2; j <= (arr.length - 1)/i ; j++){
                    arr[i*j] = false;
                }
                arr[i] = true;
            }
        }
        for (int i = 0; i< arr.length; i++){
            if ( arr[i] == true ) {
                System.out.println(i);
            }
        }
    }

    /**
     * limitation of this algorithm sieve of erathonesis is when the huge numbers are there as it
     * computes the problem in n logn it will take too much time if we deal with the number that is
     * order of 12 power of 10
     */
    public static void main(String[] args) {
        int n = 100154267;
//        System.out.println(isPrime( n ));
        sieve( 100 );
    }
}
