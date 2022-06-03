public class Rotatedarray {
    public static int findMin(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if ( nums[mid] == target )
                return mid;
            if ( nums[end] == target )
                return end;
            if ( nums[start] == target )
                return start;
            if ( nums[mid] > nums[start] ) {
                if ( target >= nums[start] && target <= nums[mid] ) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if ( target >= nums[mid] && target <= nums[end] ) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1};
        System.out.println( findMin( arr, 1 ) );
    }
}
