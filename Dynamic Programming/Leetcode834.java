// Problem Statement - Leetcode 834 - https://leetcode.com/problems/sum-of-distances-in-tree

// My Solution - using tree rerooting technique 

class Solution {
    private int currResult;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>();
        createTree(tree, n, edges);
        int[] sum = new int[n];
        currResult = 0;
        findSumFirst(tree, 0, -1, sum, 1);
        //System.out.println(currResult);

        // find for others as well.
        int[] sumDistance = new int[n];
        findDistanceForAll(0, -1, sum, sumDistance, tree, n);
        return sumDistance;
    }

    void findDistanceForAll(int root, int parent, int[] sum, int[] sumDistance, List<List<Integer>> tree, int n){
        sumDistance[root] = currResult;
        List<Integer> temp = tree.get(root);
        for(Integer i: temp){
            if(i == parent){
                continue;
            }
            currResult = currResult - sum[i] + n - sum[i];
            findDistanceForAll(i, root, sum, sumDistance, tree, n);
            currResult = currResult + sum[i] - n + sum[i];
        }
    }

    void findSumFirst(List<List<Integer>> tree, int root, int parent, int[] sum, int distance){
        List<Integer> temp = tree.get(root);
        sum[root]++;
        for(Integer i: temp){
            if(i == parent){
                continue;
            }
            currResult += distance;
            findSumFirst(tree, i, root, sum, distance+1);
            sum[root] += sum[i];
        }
            
    }

    void createTree(List<List<Integer>> tree, int n, int[][] edges){
        for(int i=0; i<n; i++){
            tree.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            tree.get(edges[i][0]).add(edges[i][1]);
            tree.get(edges[i][1]).add(edges[i][0]);
        }
    }
}
