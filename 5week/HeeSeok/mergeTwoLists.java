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
        //System.out.println("hi");
        
        ListNode head1=l1;
        ListNode head2=l2;
        ListNode newList;
        ListNode newListHead;
        if(head1 != null && head2!=null){
        if(head1.val>head2.val){
            newList = new ListNode(head2.val);
            head2=head2.next;
        }else{
            newList = new ListNode(head1.val);
            head1=head1.next;
        }
        }
        
        else if(head1!= null && head2==null){
            newList = new ListNode(head1.val);
            head1=head1.next;
        }
        else if(head1==null && head2!= null){
            newList = new ListNode(head2.val);
            head2=head2.next;
        }
        
        else{
            newList=null;
        }
        
       newListHead = newList;
       while(head1 != null || head2 != null){
        
           if(head1 !=null && head2 != null){
            if(head1.val<head2.val)
            { 
                ListNode tmp = new ListNode(head1.val);
                newListHead.next = tmp;    
                if(newListHead.next != null){
                  newListHead=newListHead.next;      
                }
                head1=head1.next;               
            }
            else{               
                ListNode tmp = new ListNode(head2.val);
                newListHead.next = tmp;    
                newListHead=newListHead.next;                
                head2=head2.next;                
            }
           }
        else if(head1!= null && head2 ==null){
                ListNode tmp = new ListNode(head1.val);
                newListHead.next=tmp;
                newListHead=newListHead.next;                
                head1=head1.next;
            
            
            }
        else if(head2 != null && head1 ==null){
            ListNode tmp = new ListNode(head2.val);
            newListHead.next=tmp;
            newListHead=newListHead.next;                
            head2=head2.next;
        }
        }

    
       return newList;
    }
}
