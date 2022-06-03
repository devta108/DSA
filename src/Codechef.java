import java.util.*;

//import java.util.Scanner;
//
public class Codechef {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        Queue<Integer> queue = new PriorityQueue<>();

        // Use add() method to add elements in the Stack
        stack.push("Geeks");
        stack.push("for");
        stack.push("Geeks");
        stack.push("10");
        stack.push("20");
        stack.pop();
        queue.add( 10 );
//        queue.add( 105 );
        queue.add( 100);
        queue.add( 150 );
        queue.add( 200 );
        System.out.println(queue);
//        queue.remove();
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        // Displaying the Stack
//        System.out.println("Stack: " + stack);
//
//        // Fetching the specific element from the Stack
//        System.out.println("The element is: "
//                + stack.get(2));




//        System.out.println(t);
    }
}
//
