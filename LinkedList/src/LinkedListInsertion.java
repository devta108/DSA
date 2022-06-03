import java.util.*;
public class LinkedListInsertion {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
        Node(){
            next = null;
        }
    }
    public void push(int newData){
        // this method pushes data at the top of the linked list aka just below the head
        Node newNode = new Node( newData );
        newNode.next = head;
        head = newNode;
    }
    public void insertAt(int prevDataNode, int newValue){
        Node prevNode = head;
        while(prevNode.data != prevDataNode){
              prevNode = prevNode.next;
        }
        if( prevNode == null){
            System.out.println("Provide the previous node...");
            return;
        }
        Node newNode = new Node(newValue);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }
//    public boolean detectLoop(){
//        return true;
//    }
    public void append(int newValue){
        Node newNode = new Node(newValue);
        if ( head == null ){
            head = new Node( newValue );
            return;
        }
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        last.next = newNode;
        newNode.next = null;
    }
    public void pop(int popValue){
        Node traverse = head;
        Node prevNodePop = traverse;
//        System.out.println(prevNodePop);
//        System.out.println(prevNodePop.data);
        while(traverse.data != popValue){
           prevNodePop = traverse;
//            System.out.println(prevNodePop);
            traverse = traverse.next;
            if( traverse == null ) return;
//            System.out.println(traverse);
        }
        if ( prevNodePop.data == traverse.data ){
            head = traverse.next;
            traverse.next = null;
            prevNodePop.next = null;
//            System.out.println(nextNode.data);
        }
        prevNodePop.next = traverse.next;
        traverse.next = null;
    }
    void deleteAllList(){
        head = null;
        System.out.println("Yeah!!! List is deleted and memory will be freed by JAVA");
    }
    public void printList(){
        Node myNode = head;
        if ( head == null ) {
            System.out.println("List is empty...");
        }
        while(myNode != null){
            System.out.print(myNode.data + " ");
            myNode = myNode.next;
        }
        System.out.println();
    }
    public void countNodeInList(){
        Node myNode = head;
        int count = 0;
        if ( head == null ) {
            System.out.println("List is empty...");
        }
        while(myNode != null){
//            System.out.print(myNode.data + " ");
            count += 1;
            myNode = myNode.next;
        }
        System.out.println(count);
    }
//    Recursive Method to count the nodes of the list
    public int countRecursive(Node node){
        if ( node == null ){
            return 0;
        }
        return 1 + countRecursive( node.next );
    }
    int getCount(){
        return countRecursive( head );
    }
    public Node reverseList(Node node){
        if( head.next == null){
            System.out.println("list is empty... ");
            return node;
        }
        Node prev = null;
        Node next = null;
        Node curr = node;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
//    Node revlist(Node node){
//        return reverseList( head );
//    }
public static void main(String[] args) {
        LinkedListInsertion llist = new LinkedListInsertion();
/*        for (int i = 0; i < 10; i++) {
            llist.push( i );
        }
*/
//        llist.insertAt( 6,15 );
//        llist.insertAt( 15,16 );
        llist.append( 12 );
        llist.append( 15 );
        for (int i = 10; i < 20; i++) {
            llist.append( i );
        }
//        llist.printList();
//        llist.countNodeInList();
//        llist.reverseList();
        llist.printList();
//        llist.reverseList( llist.head );
        llist.printList();
//        System.out.println(llist.getCount());
    }
}
