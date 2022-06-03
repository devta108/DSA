import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class RemoveInvalidParenthesis {
    public static void solution(String str, int minRemoval, HashSet<String> ans) {
        if(minRemoval == 0){
            int min= getMin(str);
            if(min == 0&& !ans.contains(str)){
                ans.add(str);
                System.out.println(str);
            }
            return;
        }

        for( int i=0;i<str.length();i++){
            String left = str.substring(0,i);
            String right = str.substring(i+1);
            solution(left+right,minRemoval-1,ans);
        }
    }

    public static int getMin(String str){
        //write your code here
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }
            else if(ch == ')') if (stack.size() == 0) stack.push(ch);
            else if (stack.peek() == '(') stack.pop();
            else {
                stack.push(ch);
            }
        }
        return stack.size();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str, getMin(str),new HashSet<>());
        str = "qwertyuio";
        str.substring(0,0);
        String s1 = "0 -> 3 -> 5 -> 6 -> 9 .";
        String s2 = "0  -> 3 -> 5 -> 6 -> 9 .";
        System.out.println(s1.equals(s2));
        System.out.println();
    }
}
