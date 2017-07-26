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
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        
        ListNode mergeList;
        // l1 : 1, 6, 7, 8
        // l2 : 2, 3, 4, 9
        if(l1.val<l2.val){ // 1 < 2 시작은 l1은 가리키도록 
            mergeList = l1;
            mergeList.next = mergeTwoLists(l1.next, l2);
        }else{ // 그렇지 않을 경우 시작은 l2를 가리키도록
            mergeList = l2;
            mergeList.next = mergeTwoLists(l1, l2.next);
        }
        return mergeList;
    }
}
