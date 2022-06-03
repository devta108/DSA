import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.
 * <p>
 * You want to share the chocolate with your K friends so you start cutting the chocolate bar into K+1 pieces using K cuts
 * each piece consists of some consecutive chunks.
 * Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.
 * Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
 * <p>
 * Example 1:
 * Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
 * Output: 6
 * Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
 * <p>
 * Example 2:
 * Input: sweetness = [5,6,7,8,9,1,2,3,4], K = 8
 * Output: 1
 * Explanation: There is only one way to cut the bar into 9 pieces.
 * <p>
 * Example 3:
 * Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
 * Output: 5
 * Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
 * <p>
 * Constraints:
 * 0 <= K < sweetness.length <= 10^4
 * 1 <= sweetness[i] <= 10^5
 */
public class Solution {
    public static int MinSweetness(int[] sweetness, int k) {
        int upper = 0;
        int lower = sweetness[0];
        int subarrayCount = 0;
        for (int i : sweetness) {
            if ( i <= lower )
                lower = i;
            upper = upper + i;
        }
        upper = upper - lower;
        while (upper >= lower) {
            int mid = lower + (upper - lower) / 2;
            int tempSum = 0;
            for (int i = 0; i < sweetness.length; i++) {

                if ( tempSum + sweetness[i] < mid ) {
                    tempSum = 0;
                    subarrayCount++;
                }
                tempSum += sweetness[i];
                if ( subarrayCount > k + 1 )
                    break;
            }
            if ( subarrayCount <= k + 1 ) {
                upper = mid - 1;
                subarrayCount = 0;
            } else {
                lower = mid - 1;
                subarrayCount = 0;
            }

        }
        return lower;
    }

    public static int minimumPages(int[] pages, int readers) {
        int start = 0;
        int end = 0;
        int possibleAns = 0;
        for (int i : pages) {
            if ( i < start )
                start = i;
            end += i;
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            int subArrayCount = 0;
            int tempSum = 0;
            for (int i : pages) {
                tempSum += i;
                if ( tempSum >= mid ) {
                    tempSum = 0;
                    subArrayCount++;
                }
                if ( subArrayCount > readers )
                    break;
            }
            if ( subArrayCount >= readers )
                start = mid + 1;
            else
                end = mid - 1;
        }
        return end;
    }

    public static void main(String[] args) {
        int[] sweetness = {12, 34, 67, 90};
        int k = 2;
        Arrays.sort( sweetness );
//        System.out.println( Arrays.toString( sweetness ) );
        System.out.println( minimumPages( sweetness, k ) );

    }

    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int[] answer = {0, 0};
        Arrays.sort( aliceSizes );
        Arrays.sort( bobSizes );
        int totalAlice = 0;
        int totalBob = 0;
        int temp = 0;
        for (int i : aliceSizes) {
            totalAlice += i;
        }
        for (int i : bobSizes) {
            totalBob += i;
        }
        for (int i : aliceSizes) {
            temp += i;
            if ( temp >= (totalBob + totalAlice) / 2 ) {
                answer[0] = i;
                break;
            } else
                answer[0] = i;
        }
        temp = answer[0];
        for (int i : bobSizes) {
            temp += i;
            if ( temp == (totalBob + totalAlice) / 2 ) {
                answer[1] = i;
            } else if ( temp > (totalBob + totalAlice) / 2 ) {
                answer[1] = i;
                break;
            } else
                answer[1] = i;
        }
        return answer;
    }

    public static int possibleBoquet(int[] bloomDay, int mid, int k) {
        int sub_array = 0;
        int total = 0;
        int n = bloomDay.length;
        for (int i = 0; i < n; i++) {
            if ( bloomDay[i] <= mid )
                total++;
            else {
                if ( total >= k ) {
                    sub_array++;
                }
                total = 0;
            }
            if ( total >= k ) {
                sub_array++;
                total = 0;
            }
        }
        if ( total >= k )
            sub_array++;
        return sub_array;
    }

    public static boolean isPossible(int[] piles, int h, int mid) {
        int hours = 0;
        for (int i : piles) {
            hours += (i + mid - 1) / mid;
        }
        return (hours <= h);
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        if ( m * k > bloomDay.length )
            return -1;
        long start = bloomDay[0];
        long end = 0;
        for (int i : bloomDay) {
            if ( start > i )
                start = i;
            if ( end < i )
                end = i;
        }
        while (start < end) {
            int mid = (int) (start + (end - start) / 2);
            if ( possibleBoquet( bloomDay, mid, k ) >= m )
                end = mid;
            else
                start = mid + 1;

        }
        return (int) start;
    }

//    public static int aggressiveCows(ArrayList<Integer> stalls, int k) {
//        int t;
//        Scanner input = new Scanner( System.in );
//        t = input.nextInt();
//        while (t--) {
//            int n, cows;
//            n = input.nextInt();
//            cows = input.nextInt();
//            int [n];
//            for (int i = 0; i < n; i++) cin >> a[i];
//            sort( a, a + n );
//
//            int low = 1, high = a[n - 1] - a[0];
//
//            while (low <= high) {
//                int mid = (low + high) >> 1;
//
//                if ( isPossible( a, n, cows, mid ) ) {
//                    low = mid + 1;
//                } else {
//                    high = mid - 1;
//                }
//            }
//            cout << high << endl;
//        }
//        return 0;
//    }
}
