import java.util.TreeMap;
import java.util.TreeSet;

public class LeetCodeDailyMay7 {
    static boolean find132pattern(int[] nums) {
        int min = nums[0];
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i =2;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        int leftMin = nums[0];
        for(int j=1;j<nums.length-1;j++){
            Integer justGreater = map.ceilingKey(leftMin+1);
            if(justGreater!=null && justGreater<nums[j]) return true;
            leftMin = Math.min(leftMin,nums[j]);
            map.put(justGreater,map.get(justGreater)-1);
            if(map.get(justGreater)==0) map.remove(justGreater);
            /**
             * @ Override
             *
             */
        }
        return false;
    }

    public static void main(String[] args) {
        String s1= "";
        String s2= "a";
//        System.out.println(s1<s2);
    }
}
