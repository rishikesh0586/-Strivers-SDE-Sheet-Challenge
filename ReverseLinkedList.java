import java.io.*;
import java.util.LinkedList;


	//Following is the structure of the Singly Linked List.	
	class LinkedListNode<T> 
    {
    	T data;
    	LinkedListNode<T> next;
    	public LinkedListNode(T data) 
        {
        	this.data = data;
    	}
	}
///kindly coment out above structure

public class ReverseLinkedList
{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
             LinkedListNode prev = null;  
        LinkedListNode current = head;
    
        
        while(current != null) { 
            LinkedListNode next = current.next; 
            current.next = prev;
            prev = current;
            current = next;
        }
       return prev;
	    
    }
}