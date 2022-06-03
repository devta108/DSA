import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Basics {
    static int getBits(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num:arr){
            String binary = Integer.toBinaryString(num);
            if(binary.length()>max) max = binary.length();
        }
        return max;
    }
    static int getOnce(int[] nums){
        int totalBits = getBits(nums);
        int[] occurenceOf1 = new int[totalBits];
        System.out.println(totalBits);
        for(int i=0;i<nums.length;i++){
            int temp = nums[i];
            while (temp!=0) {
                String rsb = Integer.toBinaryString(temp & (-temp));
                int pos = occurenceOf1.length-rsb.length();
                occurenceOf1[pos]++;
                int rsb1 = temp & (-temp);
                temp = temp - rsb1;
            }
        }
        for(int i=0;i<occurenceOf1.length;i++){
            occurenceOf1[i] = occurenceOf1[i]%3;
        }
        StringBuilder binary = new StringBuilder();
//        for (int num:occurenceOf1){
//            String s = "" + num;
//            binary.app(""+num);
//        }
        binary.append(occurenceOf1);
        System.out.println(binary.toString());
//        System.out.println(Integer.parseInt("11111111111111111111111111111100",2));
        System.out.println(Arrays.toString(occurenceOf1));

        int result = Integer.parseInt(String.valueOf(binary),2);
        return result;
    }

    public static void main(String[] args) {
//        int n = 57;
//        int i = 3;
//        System.out.println(Integer.toBinaryString(49));
//        System.out.println((Integer.toBinaryString(n)));
//        System.out.println((Integer.toBinaryString(1)));
//        System.out.println(Integer.toBinaryString(1<<4));
////        System.out.println(Integer.toBinaryString(1<<4));
//        System.out.println(Integer.toBinaryString((1<<4)^n));
//        System.out.println((1<<3)^n);
//        System.out.println(Integer.toBinaryString(~1));
//        System.out.println(Integer.toBinaryString(~((1)<<6)));
//        System.out.println(((1<<3)|n)==n);
//        System.out.println(Integer.toBinaryString(85742));
//        System.out.println(Integer.toBinaryString(~(1<<2)&85742));
//        System.out.println(Integer.toBinaryString(85738));
//        System.out.println(57+0b1);
//        System.out.println(Integer.toBinaryString(58));
//        System.out.println(Integer.toBinaryString(~58));
//        System.out.println(Integer.toBinaryString(~58+0b1));
//        System.out.println(58&(~58+1));
//        System.out.println(~1);
//        System.out.println(Integer.toBinaryString(~1));
//        System.out.println(Integer.toBinaryString(1));
//        System.out.println(Integer.toBinaryString(~1+1));
//        System.out.println(58&(~58+1));
//        System.out.println((~1+1));
//        System.out.println(Math.log10(13)/Math.log10(2));
//        System.out.println(Math.floor(1.1));
//        int x = (int) Math.round(Math.log10(62)/Math.log10(2));

//        System.out.println(Integer.toBinaryString(1<<5));
//        System.out.println(Integer.toBinaryString(1));
//        System.out.println(Integer.parseInt("11001",2));
//        ArrayList<Integer> list = new ArrayList<>();
//        System.out.println(list.toArray());
//        System.out.println('z'-'a');
//        int[] arr = {-2,-2,1,1,4,1,4,4,-4,-2};
//        for(int num:arr){
//            System.out.println(num+" -> "+Integer.toBinaryString(num));
//        }
////        RSB
//        int number = -99;
//        while(number!=0){
//            int rsb = number & (~number+1);
//            System.out.println("RSB is -> "+ Integer.toBinaryString(rsb));
//            System.out.println("Number is -> "+ Integer.toBinaryString(number));
//            System.out.println(Integer.toBinaryString(number-rsb));
//            number = number - rsb;
//        }
//        System.out.println(number);
//        int xorall = 0;
//        int sumxor = 0;
//        for(int num:arr) xorall ^= num;
//        for(int i=1;i<=arr.length;i++) sumxor ^= i;
//        System.out.println(Integer.toBinaryString(xorall));
//        System.out.println(Integer.toBinaryString(sumxor^xorall));
////        System.out.println(Math.log10(31)/Math.log10(2));
//        System.out.println(getOnce(arr));
//        int result = 0;
//        for(int num: arr){
//            System.out.println(Integer.toBinaryString(num));
//            result ^= num;
//        }
//        String version1 = "1.01";
//        String[] v1 = version1.split("\\.");
//        System.out.println(Arrays.toString(v1));
//        System.out.println(Integer.toBinaryString(result));
////        System.out.println((~result));'
//        int num = 0b1110001110111;
//        System.out.println(num>>2);
//        System.out.println((20>>3));
//        for(int i = 3;i<1000;i = i+3){
//            System.out.println(Integer.toBinaryString(i)+" -> "+Integer.toBinaryString(i/3) + ", "+ i + " -> "+(i/3));
//        }
        double num = (int)Math.floor(Math.log10(2000)/Math.log10(2));
        System.out.println(Math.pow(2,Math.floor(num)));
        StringBuilder res = new StringBuilder("");
        int[] arr = {14,70,53,83,49,91,36,80,92,51,66,70};
        Arrays.sort(arr);
        for(int n:arr){
            System.out.println(n+" -> "+Integer.toBinaryString(n));
        }
        res.append('0');
        System.out.println(Integer.toBinaryString(1^3^4^8));
//        int[] arr = {5,19,8,1};
        Arrays.sort(arr);
//        double p = 1;
        int[][] costs = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        System.out.println("before sorting");
        for (int i=0;i<costs.length;i++){
            System.out.println(Arrays.toString(costs[i])+ " diff -> " + (costs[i][0]-costs[i][1]));
        }
        Arrays.sort(costs,(a,b) ->{
            int adiff = (a[0] - a[1]);
            int bdiff = (b[0] - b[1]);
//            System.out.println("adiff for "+Arrays.toString(a)+" is -> "+adiff);
//            System.out.println("bdiff for "+Arrays.toString(b)+" is -> "+bdiff);
            return (adiff< bdiff) ? -1:0;
        });
        System.out.println("after sorting");
        for (int i=0;i<costs.length;i++){
            System.out.println(Arrays.toString(costs[i])+ " diff -> " + (costs[i][0]-costs[i][1]));
        }
    }
}
