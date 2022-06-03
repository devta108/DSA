import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public static List<ArrayList<String>> groupAnagrams(String[] strs) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> anagrams = new ArrayList<>();
        ArrayList<Integer> checkIndex = new ArrayList<>();
        int[] charArray = new int[26];
        int[] compareArray = new int[26];
        for(int index =0; index< strs.length; index++){
            anagrams.clear();
            System.out.println("start "+list);
            Arrays.fill(charArray,0);
            if(checkIndex.contains(index))
                continue;
            for(int k=0; k<strs[index].length();k++){
                int place = strs[index].charAt(k);
                charArray[place -97] +=1;
            }
//            System.out.println("Place at "+strs[index] + " "+Arrays.toString(charArray));
            for(int j =0;j<strs.length;j++ ){
                Arrays.fill(compareArray,0);
                if(checkIndex.contains(j))
                    continue;
                if (index == j)
                    continue;
                for(int k=0; k<strs[j].length();k++){
                    int place = strs[j].charAt(k);
                    compareArray[place -97] +=1;
                }
//                System.out.println("compare at "+strs[j] + " "+Arrays.toString(compareArray));
//                System.out.println(Arrays.equals(charArray,compareArray));
                if (Arrays.equals(charArray,compareArray)){
//                    System.out.println(strs[j]);
                    anagrams.add(strs[j]);
//                    System.out.println(anagrams);
                    checkIndex.add(j);

                }
//                System.out.println(anagrams);
//                System.out.println(Arrays.toString(compareArray));
            }
//            System.out.println(anagrams);
            List<String> temp = new ArrayList<>();
            anagrams.add(strs[index]);
//            System.out.println(anagrams);
//            System.out.print(anagrams + " ");
            temp.addAll(anagrams);
            checkIndex.add(index);
//            System.out.println(checkIndex);
            System.out.println("Prev "+list);
            list.add((ArrayList<String>) temp);
//            System.out.println(anagrams);
            System.out.println("updated "+list);
        }
//        System.out.println(list.getClass());
        return list;
    }
    public static ArrayList<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(i<nums.length){
            int correct = nums[i] -1;
            if(correct == -1){
                i++;
                continue;
            }
            if(nums[correct] == nums[i] && i !=correct){
                nums[i] =0;
            }
            if(nums[i]==0){
                i++;
                continue;
            }
            if(i!=correct){
                int temp = nums[correct];
                nums[correct] = nums[i];
                nums[i] = temp;
            }
            else
                i++;
        }
        System.out.println(Arrays.toString(nums));
        for(int j = 0;j< nums.length;j++){
            if(nums[j] == 0){
                list.add(j+1);
            }
        }
        System.out.println(list);
        return list;
    }
    public static ArrayList<Integer> findDuplicates(int[] nums) {
        int  i =0;
        ArrayList<Integer> list = new ArrayList<Integer>();
//        while(i<nums.length){
//            int correctIndex = nums[i] -1;
//            if(i != correctIndex){
//                int temp = nums[i];
//                nums[i] = nums[correctIndex];
//                nums[correctIndex] = temp;
//            }
//            else{
//                i++;
//            }
//        }
        while(i<nums.length){
            int correctIndex = nums[i] -1;
            if(nums[i] != nums[correctIndex])
                Utility.swap(nums,i,correctIndex);
            else{
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return list;
    }
    public static int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int sum = 0;
        for(int  i =0; i<nums.length; i++){
            int correctIndex = Math.abs(nums[i])-1;
            sum += nums[i];
            if(nums[correctIndex]<0){
                result[0] = Math.abs(nums[i]);
//                 break;
            }
            else{
                nums[correctIndex] *=-1;
            }
        }
        result[1] = ((nums.length)*(nums.length +1)/2) - sum + result[0];
        System.out.println(Arrays.toString(result));
        return result;
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        Arrays.sort(nums1);
        for(int num1 : nums1){
            if (map1.containsKey(num1))
                map1.put(num1, map1.get(num1)+1);
            else
                map1.put(num1,1);
        }
        for(int num2 : nums2){
            if (map2.containsKey(num2))
                map2.put(num2, map2.get(num2)+1);
            else
                map2.put(num2,1);
        }
        if (map1.equals(map2))
        if (nums1.length> nums2.length) {
            for (int index : nums1) {
                if (!map2.containsKey(index))
                    continue;
                else{
                    if(map1.get(index)!=0&&map2.get(index)!=0) {
                        map1.put(index, map1.get(index) - 1);
                        map2.put(index, map2.get(index) - 1);
                        result.add(index);
                    }
                }
            }
        }
        else {
            for (int index : nums2) {
                if (!map1.containsKey(index))
                    continue;
                else{
                    if(map1.get(index)!=0&&map2.get(index)!=0) {
                        map1.put(index, map1.get(index) - 1);
                        map2.put(index, map2.get(index) - 1);
                        result.add(index);
                    }
                }
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i<result.size();i++){
            arr[i] = result.get(i);
        }
        return arr;
    }
    public static String[] swap(String[] arr,int index1, int index2){
        String temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return arr;
    }
    public static String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        int i= 0;
        for( int index : nums){
            strArr[i] = ""+index;
            i++;
        }
        Arrays.sort(strArr, (a,b)->{
            long n1 = Long.parseLong(a+b);
            long n2 = Long.parseLong(b+a);
            if(n2>n1){
                return -1;
            }
            else if(n2< n1){
                return 1;
            }
            else
                return 0;
        });
         String a ="", b= "",largestNumber="";
//        for (int index = strArr.length-1; index >0 ; index--) {
//            a = strArr[index];
//            b = strArr[index-1];
//            if((a+b).compareTo(b+a) < 0)
//                swap(strArr,index-1,index);
//        }

        for (int index = strArr.length-1; index >=0 ; index--) {
            largestNumber+= strArr[index];
        }
        System.out.println(Arrays.toString(strArr));
//        while(largestNumber.charAt(0) =='0'&& largestNumber.length()>1){
//            largestNumber = largestNumber.substring(1);
//        }
        return largestNumber;
    }
    public static void main(String[] args) {
        int[] arr1 = {74,21,33,51,77,51,90,60,5,56};
        int[] arr2 = {4,9,5};

//        String[] strings = {"eat","tea","tan","ate","nat","bat","tab"};
        System.out.println((largestNumber(arr1)));
//        int[] test = new int[10000];
//        findErrorNums(arr);
//        for (int i = 0; i < 10000; i++) {
//            test[i] = i;
//        }
//        System.out.println(Arrays.toString(test));
    }
}