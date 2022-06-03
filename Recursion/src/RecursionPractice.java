import javax.swing.*;
import java.sql.ClientInfoStatus;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Steps for recursion
 * 1. find out the base case(smallest problem whose solution is known)
 * 2. make reoccurence relation
 */
public class RecursionPractice {
    // find the factorial recursively
    static int factorial(int number){
        int µ = 10;
        if (number == 1)
            return 1;
        else
            return number*factorial(number-1);
    }
    // Find the nth fibonacci recursively
    static int fibonacci(int n){
        // fib(n) = fib(n-1) + fib(n-2)
        if(n  ==1|| n==0)
            return n; // base case
        int fibofNminus1 = fibonacci(n-1);
        int fibOfNminus2 = fibonacci(n-2);

        return fibofNminus1 + fibOfNminus2; // Recurrence relation

    }
    // Palindrome recursive
    static boolean isPalindrome(String str,int i,int j){
        if(i>j)
            return true;
        if (str.charAt(i)==str.charAt(j))
            return isPalindrome(str,i+1,j-1);
        else
            return false;
    }
    // Binary search recursively
    static int binarySearch(int[] arr, int target, int start, int end){
        if(start < end){
            int mid= (start+end)/2;
            if(arr[mid] == target ){
                return mid;
            }
            if(arr[mid]> target){
                return binarySearch(arr, target,start,mid-1);
            }
            else
                return binarySearch(arr, target, mid+1, end);
        }
        return -1;
    }
    // String Palindrome
    static boolean palindrome(String str, int i){
        if (i > str.length()/2)
            return true;
        if (str.charAt(i)==str.charAt(str.length() - i -1)) {
            return palindrome(str, i + 1);
        }
        else
            return false;
    }
    static double power(double x, double n){
        if (n == 0) {
            return 1;
        }
        if (x == 0 || x == 1 || n == 1) {
            return x;
        }
        if(n==-1){
            return 1/x;
        }

        double num = power(x, n / 2);

        if (n % 2 == 0) {
            return num * num;
        } else {
            if(n<0)
                return num*num*(1/x);
            else
                return num*num*x;
        }
    }
    //Print 1 to n recursively
    static void printUpto(int n){
        if (n==0)
            return;
        printUpto(n-1);
        System.out.println(n);
    }
    //Sum of digits
    static int sumOfDigits(int n){
        if(n>0)
            return n%10+sumOfDigits(n/10);
        else
            return n;
    }
    // Reverse a number recursively
    static int reverseNumber(int num,int digit){
        int reverse=0;
        if(num>0) {
            return (num%10)*(int)Math.pow(10,digit-1)+reverseNumber(num/10,digit-1);
        }
        else
            return num;
//        return reverse;
    }
//    static int sum = 0;
    static List<List<Integer>> list = new ArrayList<>();
//    print all subsets of given n element array recursively
    static void printSubarray(int index, int[] arr, ArrayList<Integer> subArray, int sum){
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(index >= arr.length || sum <=0){
            if(sum != 0)
                return;
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i: subArray){
                temp.add(i);
            }
            list.add(temp);
            return;
        }
        subArray.add(arr[index]);
        printSubarray(index,arr,subArray,sum-arr[index]);
        subArray.remove(subArray.size()-1);
        printSubarray(index+1,arr,subArray,sum);
    }
    static void printSubarrayDivisible(int index, int[] arr, int sum, int size){
        if(index >= arr.length){
            if(sum%3==0)

//                System.out.println(sum);
            return;
        }
//        subArray.add(arr[index]);
        sum = sum+arr[index];
        printSubarrayDivisible(index+1,arr,sum,size);
        sum = sum-arr[index];
        printSubarrayDivisible(index+1,arr,sum,size);
//        return;
    }
    static double expectedAmount(int investpermonth, int months, int avgReturn){
        double sum = 0;
        for(int i=1;i<=months;i++)
        {
//            sum += (sum*0.15)/(1+0.08);
            sum +=investpermonth+(sum*(0.15-0.08));
        }
        return sum;
    }
//    Matrix path
    static void path(int i,int j,int startX,int startY, Stack<String> path){
        if (startX>j||startY>i) return;
        if(startX ==j && startY==i){
            System.out.println(path);
            return;
        }
        path.add("R");
        path(i,j,startX+1,startY,path);
//        System.out.println(path);
        path.pop();
        path.add("D");
        path(i,j,startX,startY+1,path);
        path.pop();
    }
    static String invert(String str) {
        char[] array = str.toCharArray();
        for(int index=0;index<array.length;index++){
            if(array[index]==0)
                array[index]='1';
            else
                array[index] = '0';
        }
        return array.toString();
    }
    static String reverse(String str){
        char[] array = str.toCharArray();
        for (int index=0; index<array.length/2;index++){
            char temp  = array[index];
            array[index]=array[array.length-index-1];
            array[array.length-index-1]=temp;
        }
        return array.toString();
    }
    static String Si2 = "";
    static String builder(int n){
        if(n==1)
            return "0";
        Si2 = builder(n-1);
        System.out.println(Si2);
        return Si2 + "1" + reverse(invert(Si2));
    }
//        String 0 1 2 3 4 5 6  7 8 9
//    1545. Find Kth Bit in Nth Binary String
    static String findKthBit(int n, int k) {
    if(n==1)
        return "0";

//    Si = findKthBit(n-1) + "1" + invert();
    return "";
}
    static void towerOfHanoi(int noOfDics,char source,char helper, char destination){
        if(noOfDics == 1){
            System.out.println("move disc number " + noOfDics+" from " + source+" to "+ destination);
            return;
        }
        else {
            towerOfHanoi(noOfDics - 1, source, destination, helper);
            System.out.println("move disc number " + noOfDics + " from " + source + " to " + destination);
            towerOfHanoi(noOfDics - 1, helper, source, destination);
        }
//        System.out.println("put disc number " + noOfDics+" from " + source+" to "+ destination+" using "+ helper);

    }
    public static void main(String[] args) {
        Stack<String> path = new Stack<>();
        towerOfHanoi(3,'a','b','c');
//        nishek sharma is aatma
//        double n = Math.log10(536870911)/Math.log10(2);
//        String name = "1000100111";
//        name.replace('i','e');
//        name.substring('i');
//        System.out.println(name.substring(0,8)+"0"+name.substring(9));
//        System.out.println(name.length());
//        System.out.println((name.substring(0,8)+"0"+name.substring(9)).length());
//        System.out.println(n);
//        System.out.println(builder(3));
        String str = "0";
        StringBuilder s1 = new StringBuilder("");
//        for (int i = 0; i <str.length(); i++) {
//            if(s1.charAt(i)=='0' && s1.charAt(s1.length()-i-1)=='0'){
//                System.out.println(1);
//                s1.replace(i,i+1,"1");
//                s1.replace(s1.length()-i-1,s1.length()-i,"1");
//            }
//            else if(s1.charAt(i)=='1' && s1.charAt(s1.length()-i-1)=='0'){
//                System.out.println(2);
//                s1.replace(i,i+1,"0");
//                s1.replace(s1.length()-i-1,s1.length()-i,"1");
//            }
//            else if(s1.charAt(i)=='1' && s1.charAt(s1.length()-i-1)=='1'){
//                System.out.println(3);
//                s1.replace(i,i+1,"0");
//                s1.replace(s1.length()-i-1,s1.length()-i,"0");
//            }
        long n = 100;
        System.out.println((int)((Math.pow(5,(n+1)/2)%(1e9 + 7)*Math.pow(4,n/2)%(1e9 + 7))%(1e9+7)));
        System.out.println(10%11);
//            else{
//                System.out.println(4);
//                s1.replace(i,i+1,"1");
//                s1.replace(s1.length()-i-1,s1.length()-i,"0");
//            }
//                if(str.charAt(i)=='0') {
//                    s1.append("1");
//                }
//                else {
//                    s1.append("0");
//                }
//            }
//        System.out.println(s1);
            System.out.println(power(2,10));
//        s1.replace(0,1,"1");
//        System.out.println(s1.charAt(14));

//        path(4,3,0,0,path);
//        int number = 5;
//        int[] arr = { 0};
//        String str = "abcdecba";
//        list.clear();
//        double x = 1.4732279364480948E19;
//        System.out.println(x);
//        path(4,3,0,0,"");
//        System.out.println(expectedAmount(2000,12,15));
//        Nishek sharma System.out
//        System.out.println(binarySearch(arr,9,0, arr.length-1));
//        System.out.println(palindrome(str,0));
//        System.out.println(isPalindrome(str,0,str.length()-1));
//        int digit = (int)(Math.log10(123456))+1;
//        System.out.println(reverseNumber(123456,digit));
//        printUpto(10);
//        System.out.println(sumOfDigits(1234567890));
//        System.out.println(9/10);
//        System.out.println(binarySearch(arr,9,0,arr.length-1));
//        ArrayList<Integer> subArray = new ArrayList<>();
//        List<List<Integer>> list = new ArrayList<>();
//        printSubarray(0,new int[]{4, 2, 3},subArray,3);
//        printSubarray(0,arr,subArray,arr.length);
//        System.out.println(list);
//        list.clear();
//        int[] arr = {1,2,3};
//        printSubarray(0,new int[]{1,2,3},subArray,4);
//        System.out.println(list);
//        printSubarray(0,new int[]{1,2,3},subArray,arr.length);
//        System.out.println(list);
//        printSubarray(0,new int[]{1,2,3},subArray,arr.length);
//        System.out.println(list);
//        printSubarrayDivisible(0,new int[]{4, 2, 3},0,3);
    }
}
