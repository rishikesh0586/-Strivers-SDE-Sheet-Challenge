/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 };

 *****************************************************************/

public class Solution {
    public static Node rotate(Node head, int k) {
        // Write your code here.
    

    Node temp = new Node();
        temp = head;
        if(head==null || head.next==null || k==0) return head;
        int count = 1;
        while(temp.next!=null){
            temp = temp.next;
            count++;
        }

        temp.next = head;
        k = k%count;
        k = count-k;

        while(k-->0){
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}