/************************************************************

    Following is the Tree node structure
	
	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

************************************************************/

public class Solution {
    static long max;
	public static long findMaxSumPath(TreeNode root) {
		// Write your code here.
        if(root==null)
            return -1;
        max = -1l;
        maxPathSumUtil(root);
        return max;
	}
    public static int maxPathSumUtil(TreeNode node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return node.data;
 
        int ls = maxPathSumUtil(node.left);
        int rs = maxPathSumUtil(node.right);
 
        if (node.left != null && node.right != null) {
 
            max = Math.max(max, ls + rs + node.data);
 
            return Math.max(ls, rs) + node.data;
        }
        return (node.left == null) ? rs + node.data
                : ls + node.data;
    }
}