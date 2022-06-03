import java.util.ArrayList;

public class Stack {
    public static class CustomStack {
        int[] arr;
        int top;

        public CustomStack(int cap) {
            arr = new int[cap];
            top = -1;
        }

        int size() {
            // write ur code here
            return top+1;
        }

        void display() {
            // write ur code here
            for(int i=top;i>=0;i--){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        void push(int val) {
            // write ur code here
            if(top == arr.length-1){
                System.out.println("Stack overflow");
                return;
            }
            else{
                top++;
                arr[top] = val;
            }
        }

        int pop() {
            // write ur code here
            if(top==-1){

                System.out.println("Stack underflow");
                return -1;
            }
            else{
                top--;
                return arr[top+1];
            }
        }

        int top() {
            if(top==-1){
                System.out.println("Stack underflow");
                return -1;
            }
            else{
                return arr[top];
            }
        }
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(10);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.display();
    }
}
