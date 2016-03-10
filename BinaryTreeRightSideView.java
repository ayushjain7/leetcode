// https://leetcode.com/problems/binary-tree-right-side-view/

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<>();
        if(root == null)
            return rightSideView;

        List<List<TreeNode>> traversal = new ArrayList<>();
        traversal.add(Collections.singletonList(root));
        int i=0;
        while(i<traversal.size() && !traversal.get(i).isEmpty()){
            List<TreeNode> curLevel = traversal.get(i);
            List<TreeNode> nextLevel = new ArrayList<>();
            for(TreeNode node : curLevel){
                if(node.left!=null)
                    nextLevel.add(node.left);
                if(node.right!=null)
                    nextLevel.add(node.right);
            }
            if(!nextLevel.isEmpty())
                traversal.add(nextLevel);
            i++;
        }

        for(List<TreeNode> level : traversal){
            rightSideView.add(level.get(level.size()-1).val);
        }
        return rightSideView;
    }}
