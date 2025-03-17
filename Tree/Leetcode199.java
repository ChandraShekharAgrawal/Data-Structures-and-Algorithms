// Problem Statement - Leetcode 199 - https://leetcode.com/problems/binary-tree-right-side-view/

// My solution - java

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null)
            queue.add(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            int last = 0;
            for(int i=0; i<queueSize; i++){
                TreeNode temp = queue.remove();
                last = temp.val;
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }            
            rightView.add(last);
        }
        return rightView;
    }
}
