import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the LinkedListNode class:
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

public class Solution {

	public static boolean isPalindrome(LinkedListNode<Integer> head) {
		// Write your code here!


        LinkedListNode fast=head,slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //if the ll size is odd 
        if(fast!=null){
            slow=slow.next;
        }
        slow=reverseList(slow);//right half ll
        fast=head;//left half ll

        // compare two lls
        while(slow!=null){
           if(fast.get(val)!=slow.get(val))
                return false;
        
            fast=fast.next;
            slow=slow.next;
        }
        return true;
    }
    public static LinkedListNode reverseList(LinkedListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        LinkedListNode prevNode=head;
        LinkedListNode currNode=head.next;
        while(currNode!=null){
            LinkedListNode nextNode=currNode.next;
            currNode.next=prevNode;//does the reversing part
 
            //update
            prevNode=currNode;
            currNode=nextNode;
        }
        head.next=null;
        head=prevNode;
        return head;
    		
	}
}