/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
               
        if(l1 == null && l2 == null) return null;
        if(l1 != null && l2 == null) return l1;
        if(l1 == null && l2 != null) return l2;
        
        ListNode l3 = null;
        if(l1.val > l2.val){
            l3 = new ListNode(l2.val);
            l2 = l2.next;
        }
        else{
            l3 = new ListNode(l1.val);
            l1 = l1.next;
        }
        
        l3.next = mergeTwoLists(l1, l2);
        
        return l3;
    }
    
}
