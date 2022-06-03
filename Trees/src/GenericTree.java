import java.util.*;

public class GenericTree {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    static void display(Node root){
        String str = root.data + " -> ";
        for (Node child : root.children){
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);
        for(Node child : root.children){
            display(child);
        }
    }

    public static void main(String[] args) {
        GenericTree tree1 = new GenericTree();
        Node root = null;
        int[] nodes = {10 ,20 ,-1, 30, 50, -1, 60, -1, -1, 40, -1, -1};
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < nodes.length; i++) {
            Node node = new Node();
            if(nodes[i]==-1){
                if(stack.isEmpty()){
                    return;
                }
                stack.pop();
            }
            else{
                if(stack.size()==0){
                    node.data = nodes[i];
                    root = node;
                    stack.push(root);
                }
                else{
                    node.data = nodes[i];
                    stack.peek().children.add(node);
                    stack.push(node);
                }
            }
        }
        display(root);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        System.out.println(arr);
        Queue<Node> Q = new ArrayDeque<>();
        Q.add(root);
        System.out.println(arr);
        arr.remove(arr.indexOf(1));
        System.out.println(arr);
    }
}