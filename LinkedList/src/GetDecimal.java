/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer
 * /**
 *  * Definition for singly-linked list.
 *  * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode() {}
 *  *     ListNode(int val) { this.val = val; }
 *  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *  * }
 *  */

public class GetDecimal {
    /**
     * type 1 solution
     */
    /*public int getDecimalValue(ListNode head) {
        String = "";
        int counter = 0;
        int decimalValue = 0;
        ListNode traverse = new ListNode();
        traverse = head;
        while(traverse != null){
            list.add(traverse.val);
            traverse = traverse.next;
        }
        int size  = list.size();
        for (int index = 0; index < list.size(); index++){
            if(list.get(index )==1){
                decimalValue += (int) (Math.pow( 2, (size - 1 - index) ));
            }
        }
        return decimalValue;
    }
        return 0;*/
    /**
     * type 2 Solution
     */
    public static void main(String[] args) {
        String s = "";
        int a = 10;
        s = s + (a);
        int b = 10;
        s = s + (b);
        s = "000111110001";
        int decimalValue = 0;
        for (int index = 0; index < s.length(); index++){
            if(s.charAt( index ) == '1'){
                decimalValue += (int) (Math.pow( 2, (s.length() - 1 - index) ));
            }
        }
        System.out.println(s);
        System.out.println(decimalValue);
    }
}

