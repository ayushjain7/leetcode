// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestor(root, p, q, new boolean[]{false, false});
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, boolean[] found) {
        if(root==null)
            return null;
        
        boolean[] leftBool = new boolean[]{false, false};
        boolean[] rightBool = new boolean[]{false, false};
        
        TreeNode retLeft = lowestCommonAncestor(root.left, p, q, leftBool);
        if(retLeft!=null)
            return retLeft;
        
        TreeNode retRight = lowestCommonAncestor(root.right, p, q, rightBool);
        if(retRight!=null)
            return retRight;

        found[0] = (leftBool[0] || rightBool[0] || root==p);
        found[1] = (leftBool[1] || rightBool[1] || root==q);
        
        if(found[0]&&found[1])
            return root;
        return null;
    }
}
