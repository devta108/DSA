import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class LeetcodeContest {

    static HashMap<Character,Integer> makemap(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }
        return map;
    }
    public static int minSteps(String s, String t) {
        HashMap<Character,Integer> smap = makemap(s);
        HashMap<Character,Integer> tmap = makemap(t);

        if(smap.equals(tmap)) return 0;

        int result = 0;
        for(char ch : smap.keySet()){
            if(tmap.containsKey(ch)){
                int diff = tmap.get(ch) - smap.get(ch);
                result += (diff>0)? diff:smap.get(ch)-tmap.get(ch);
            }
            else{
                result += smap.get(ch);
            }
        }
        for(char ch: tmap.keySet()){
            if(!smap.containsKey(ch)){
                result += smap.get(ch);
            }
        }
        return result;
    }
    static int[] map = new int[10];
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
    static int[] sortJumbled(int[] arr){
        int[] result = new int[arr.length];
//        Arrays.asList(arr);
        List<Integer> list = new ArrayList(Arrays.asList(arr));

        Collections.sort(list,(a,b) -> {
            int tempa = mapify(a);
            int tempb = mapify(b);
            return tempa-tempb;
        });
        return arr;
    }

    public static void main(String[] args) {
        String s = "leetcode", t = "coats";
//        System.out.println(minSteps(s,t));
        int i = 2147483647;
        long n = Long.MAX_VALUE;
        System.out.println(Long.toBinaryString(n));
        System.out.println(Long.toBinaryString(n/2));
        System.out.println((4&1)^(5&1));
        System.out.println((4^5)&(1^1));
        System.out.println(Integer.toBinaryString(10)+" "+ Integer.toBinaryString(10>>2));
//        for(i =0;i<50;i++){
//            System.out.println(i+" -> "+Integer.toBinaryString(i));

//        }
        System.out.println(Integer.toBinaryString(248));
        System.out.println(Integer.toBinaryString(130));
        System.out.println(Integer.toBinaryString(130));
        System.out.println(Integer.toBinaryString(130));
        System.out.println(Integer.parseInt("11110000",2));
        System.out.println(Integer.toBinaryString(1<<7));
        System.out.println(Math.log10(1_000_000_000)/Math.log10(2));
        System.out.println(1e9);
        System.out.println(1<<30);
        System.out.println(1<<0);
        System.out.println(Math.log10(7)/Math.log10(2));
        int left = 5, right = 7;
        double leftmsb = (Math.log10(left))/Math.log10(2);
        double rightmsb = (Math.log10(right))/Math.log10(2);
        System.out.println((int)Math.floor(rightmsb));
        System.out.println(leftmsb + " "+ rightmsb);
        System.out.println(1<<31 );
    }

}
