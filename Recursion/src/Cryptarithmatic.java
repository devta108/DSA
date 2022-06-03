import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Cryptarithmatic {
    static boolean isPossible(HashMap<Character,Integer> map,String[] words, String result){
        String[] nums = new String[words.length];
        for(int i=0;i<words.length;i++){
            String word = words[i];
            String num = "";
            for(int j=0;j<word.length();j++){
                num += map.get(word.charAt(j));
            }
            // System.out.println("for Word "+word+" num is "+num);
            nums[i] = num;
        }
        int sum = 0;
        for(String num:nums){
            sum += Integer.parseInt(num);
        }
        String rNum = "";
        for(int i=0;i<result.length();i++){
            rNum += map.get(result.charAt(i));
        }
        int resNum = Integer.parseInt(rNum);
        // System.out.println(sum+" "+resNum);
//         System.out.println(map);
        return sum==resNum;
    }
    static boolean createMap(HashMap<Character,Integer> map,boolean[] isTaken,String[] words,String result){
        char ch = '\u0000';
        for(char c: map.keySet()){
            if(map.get(c)==-1){
                ch = c;
                break;
            }
        }
        if(ch=='\u0000'){
            boolean res = isPossible(map,words,result);
            if(res) {
//                Collectionmain
                for(char c: map.keySet()){
                    System.out.print(c+"-"+map.get(c)+" ");
                }
                System.out.println();
            }
            return res;
        }
        for(int i=0;i<10;i++){
            if(isTaken[i]) continue;
            map.put(ch,i);
            isTaken[i] = true;
            boolean res = createMap(map,isTaken,words,result);
//            if(res) return res;
            map.put(ch,-1);
            isTaken[i] = false;
        }
        return false;
    }
    static boolean isSolvable(String[] words, String result) {
        HashMap<Character,Integer> map = new HashMap<>();
        buildMap(map,words,result);
        if(map.size()>10) return false;
        boolean[] isTaken = new boolean[10];
        boolean res = createMap(map,isTaken,words,result);
        System.out.println(map);
        return res;
    }
    static void buildMap(HashMap<Character,Integer> map, String[] words, String result){

        for(String word:words){
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if(map.containsKey(ch)) continue;
                else map.put(ch,-1);
            }
        }
        for(int i= 0;i<result.length();i++){
            char ch = result.charAt(i);
            if(map.containsKey(ch)) continue;
            else map.put(ch,-1);
        }
    }

    public static void main(String[] args) {
        String[] words = {"team","pep"};
        String result = "toppr";
//        Object o2
        char[] arr = result.toCharArray();
        Arrays.sort(arr);
        boolean res = isSolvable(words,result);
        System.out.println(res);
//        String str = "qwerty";
//        System.out.println(str.substring(7));
    }
}
