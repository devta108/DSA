import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Biweekly {
    static int[] map = {0,5,6,7,8,9,1,2,3,4};

    static int[] nums = {585275682,246861473,16927462,591267979,84859737,31281267,16868060,11972781,659883143,736081964,458482039,530067227,810187159,884017736,34397146,219394005,790136503,759263939,403688914,16464373,841482403,863559744,262808631,34897188,634232334,883137739,683086911,60348125,9329421,397768858,538305734,551375577,104837009,862078979,230314498,12999495,988942722,872090401,288954078,431003477,160841108,556606009,667899889,564969604,283280077,888914249,646892559,478194863,391944797,195376300,310534027,315924916,70303245,641846389,195085242};
    static int mapify(int num){
        String str = ""+num;
        String res = "";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            res += map[ch - '0'];
        }
        int result = Integer.parseInt(res,10);
        return result;
    }
    public static void main(String[] args) {
//        for(int i=0;i<map.length;i++){
//            map[i] = mapping[i];
//        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num:nums) list.add(num);

        Collections.sort(list,(a, b)->{
            int tempa = mapify(a);
            int tempb = mapify(b);
            return tempa-tempb;
        });
        for(int i=0;i<nums.length;i++){
            nums[i] = (int)list.get(i);
        }
        System.out.println(Arrays.toString(nums));
    }
}

