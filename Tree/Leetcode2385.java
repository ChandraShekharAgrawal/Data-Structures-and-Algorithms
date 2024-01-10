// Problem Statement - Leetcode 2385 - https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected

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
    private TreeNode startNode = null;

    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        HashSet<TreeNode> visited = new HashSet<>();
        createParent(root, parent, start);
        return findFarthestNode(startNode, visited, parent) - 1;
    }

    void createParent(TreeNode root, HashMap<TreeNode, TreeNode> parent, int start){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() != 0){
            TreeNode temp = q.remove();
            if(temp.val == start){
                startNode = temp;
            }
            if(temp.left != null){
                parent.put(temp.left, temp);
                q.add(temp.left);
            }
            if(temp.right != null){
                parent.put(temp.right, temp);
                q.add(temp.right);
            }
        }
    }

    int findFarthestNode(TreeNode node, HashSet<TreeNode> visited, HashMap<TreeNode, TreeNode> parent){
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        visited.add(node);
        while(q.size() != 0){
            int qsize = q.size();
            for(int i=0; i<qsize; i++){
                TreeNode temp = q.remove();
                TreeNode tempParent = parent.get(temp);
                if(tempParent != null && visited.contains(tempParent) == false){
                    q.add(tempParent);
                    visited.add(tempParent);
                }
                if(temp.left != null && visited.contains(temp.left) == false){
                    q.add(temp.left);
                    visited.add(temp.left);
                }
                if(temp.right != null && visited.contains(temp.right) == false){
                    q.add(temp.right);
                    visited.add(temp.right);
                }
            }
            ans++;
        }
        return ans;
    }
}
