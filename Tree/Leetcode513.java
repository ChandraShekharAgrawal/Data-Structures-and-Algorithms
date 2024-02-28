// Problem Statement - Leetcode 513 - https://leetcode.com/problems/find-bottom-left-tree-value

// My Solution

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
    public int findBottomLeftValue(TreeNode root) {
        int[] ans = {0};
        bfs(root, ans);
        return ans[0];
    }

    void bfs(TreeNode root, int[] ans){
        if(root == null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0){
            int qsize = q.size();
            for(int i=0; i<qsize; i++){
                TreeNode temp = q.remove();
                if(i==0){
                    ans[0] = temp.val;
                }
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
        }
    }
}
