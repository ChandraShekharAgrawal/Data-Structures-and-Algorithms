// Problem Statement - Leetcode 2049 - https://leetcode.com/problems/count-nodes-with-the-highest-score

// My Solution - good use of dfs with some tweaks

class Solution {
    private long productAns;
    private int countAns;
    public int countHighestScoreNodes(int[] parents) {
        int nodes = parents.length;
        List<List<Integer>> tree = new ArrayList<>();
        productAns = 1L;
        countAns = 0;
        createTree(tree, parents, nodes);

        // create ans for root
        
        countNodeAndProduct(tree, nodes, 0);        

        return countAns;

    }
    

    long countNodeAndProduct(List<List<Integer>> tree, int nodes, int root){
        long nodeCount = 1L;
        Long tempProduct = 1L;
        List<Integer> children = tree.get(root);
        
        for(Integer i: children){
            
            long childNode = countNodeAndProduct(tree, nodes, i);
            nodeCount += childNode;
            tempProduct *= childNode;
            //product *= countNodes[i];
        }
        tempProduct *= Math.max(1, nodes-nodeCount);
        if(tempProduct > productAns){
            productAns = tempProduct;
            countAns = 1;
        }
        else if(tempProduct == productAns){
            countAns++;
        }
        return nodeCount;        
    }

    void createTree(List<List<Integer>> tree, int[] parents, int nodes){
        for(int i=0; i<nodes; i++){
            tree.add(new ArrayList<>());
        }
        for(int i=1; i< nodes; i++){
            tree.get(parents[i]).add(i);
        }
    }
}
