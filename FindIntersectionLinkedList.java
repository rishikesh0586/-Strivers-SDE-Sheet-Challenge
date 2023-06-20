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
 }

 *****************************************************************/
import java.util.*;

public class Solution {
    public static int findIntersection(Node firstHead, Node secondHead) {
        Node d1 = firstHead;
        Node d2 = secondHead;
    
        while (d1 != d2) {
            d1 = (d1 == null) ? secondHead : d1.next;
            d2 = (d2 == null) ? firstHead : d2.next;
        }
    
        if (d1 == null) {
            throw new NoSuchElementException("No intersection found");
        }
        
        return d1.data;
    }
}
