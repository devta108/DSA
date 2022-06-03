import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by
 * continuously following the next pointer. Internally, pos is used to denote the index of the node
 * that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Link :- https://leetcode.com/problems/linked-list-cycle/
 */

public class DetectLoopLL {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add( i*10 );
        }
        System.out.println(list);
        int mid  = Math.round( (float)(list.size()/2) );
        System.out.println(mid);
        System.out.println(list.get( mid ));
//        Less space
        /*if(head==null || head.next == null){
            return false;
        }
        ListNode fast = head;
        // ListNode slow = head;
        while(fast.next!= null && fast.next.next != null){
            fast = fast.next.next;
            head = head.next;
            if(fast == head){
                return true;
            }
        }
        return false;*/
    }
}
