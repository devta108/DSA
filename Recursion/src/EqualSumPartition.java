import java.util.Arrays;

public class EqualSumPartition {
    static int sumSubset;
    static boolean createSubsets(int[] nums,boolean[] isTaken,int[] subsets,int takenElements){
        if(takenElements == nums.length){
            for(int subset:subsets){
                if(subset != sumSubset) return false;
            }
            System.out.println(Arrays.toString(subsets));
            return true;
        }
        boolean isZeroFilled = false;
        for(int i=0;i<nums.length;i++){
            if(isTaken[i]) continue;
            isTaken[i] = true;
            for(int j =0;j<subsets.length;j++){
                if(subsets[j]==0&& !isZeroFilled){
                    if(subsets[j]+nums[i]>sumSubset) continue;
                    isZeroFilled = true;
                    subsets[j] += nums[i];
                    boolean res = createSubsets(nums,isTaken,subsets,takenElements+1);
                    if(res) return res;
                    subsets[j] -= nums[i];
                }
                else if(subsets[j]+nums[i]<=sumSubset){
                    subsets[j] +=nums[i];
                    boolean res = createSubsets(nums,isTaken,subsets,takenElements+1);
                    if(res) return res;
                    subsets[j] -= nums[i];
                }
            }
            isTaken[i] = false;
        }
        return false;
    }
    static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num:nums) sum += num;
        if(sum%k != 0) return false;
        sumSubset = sum/k;
        boolean[] isTaken = new boolean[nums.length];
        int[] subsets = new int[k];
        System.out.println(sumSubset);
        return createSubsets(nums,isTaken,subsets,0);
    }

    public static void main(String[] args) {
        int[] nums = {3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269};
        int k = 4;
        System.out.println(canPartitionKSubsets(nums,k));
    }
    int dfs(int[][] grid,int r,int c, int clr){
        if(r==grid.length||c == grid[0].length||r<0||c<0||(Math.abs(grid[r][c]) != clr)){
            return 0;
        }
        if(grid[r][c] == -clr) return 1;
        if(grid[r][c] == clr) grid[r][c] = -clr;
        int count = 0;
        count += dfs(grid,r-1,c,clr);
        count += dfs(grid,r,c+1,clr);
        count += dfs(grid,r+1,c,clr);
        count += dfs(grid,r,c-1,clr);
        if(count == 4) grid[r][c] = -grid[r][c];

        return 1;
    }
}
