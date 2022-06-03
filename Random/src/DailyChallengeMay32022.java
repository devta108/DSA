public class DailyChallengeMay32022 {
    class Solution {
        static class Pair{
            int max;
            int min;
            Pair(int max,int min){
                this.max = max;
                this.min = min;
            }
        }
        static Pair minMaxOfArray(int[] nums,int start,int end){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i=start;i<=end;i++){
                if(max<nums[i]) max = nums[i];
                if(min>nums[i]) min = nums[i];
            }
            return new Pair(max,min);
        }
        public static int findUnsortedSubarray(int[] nums) {
            int left = 0;
            int right = nums.length-1;
            int result = 0;
            while(left<=right){
                Pair temp = minMaxOfArray(nums,left,right);
                if(temp.min == nums[left]&& temp.max == nums[right]){
                    right--;
                    left++;
                }
                else if(temp.min == nums[left]&& temp.max != nums[right]){
                    left++;
                }
                else if(temp.min != nums[left]&& temp.max == nums[right]){
                    right--;
                }
                else{
                    return (right - left +1);
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        int res = Solution.findUnsortedSubarray(nums);
        System.out.println(res);
    }
}
