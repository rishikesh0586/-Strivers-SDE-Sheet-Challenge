//this is code studio solution
    




public class Solution {
	public static void deleteNode(LinkedListNode<Integer> node) {

          node.data = node.next.data;
     node.next = node.next.next;
	}
}