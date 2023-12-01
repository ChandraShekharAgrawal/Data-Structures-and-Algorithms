// Problem Statement - Leetcode 1743 - https://leetcode.com/problems/restore-the-array-from-adjacent-pairs

// My Solution

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        // create a graph
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        int n = adjacentPairs.length;
        for(int i=0; i<n; i++){
            if(graph.containsKey(adjacentPairs[i][0]) == false){
                graph.put(adjacentPairs[i][0], new ArrayList<>());
            }
            if(graph.containsKey(adjacentPairs[i][1]) == false){
                graph.put(adjacentPairs[i][1], new ArrayList<>());
            }
            graph.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]);
            graph.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]);
        }
        // find ending/starting
        int start = findStart(graph);
        int[] storedArray = new int[n+1];
        HashSet<Integer> vis = new HashSet<>();
        storedArray[0] = start;
        vis.add(start);
        // call dfs to add other values
        dfs(storedArray, n+1, graph,1, start, vis);
        return storedArray;
    }

    void dfs(int[] storedArray, int n, HashMap<Integer, ArrayList<Integer>> graph, int index, int key, HashSet<Integer> vis){
        for(int i=0; i<graph.get(key).size(); i++){
            if(vis.contains(graph.get(key).get(i)) == false){
                storedArray[index] = graph.get(key).get(i);
                vis.add(graph.get(key).get(i));
                dfs(storedArray, n, graph, index+1, graph.get(key).get(i), vis);
            }
        }
    }


    int findStart(HashMap<Integer, ArrayList<Integer>> graph){
        for(Integer i: graph.keySet()){
            if(graph.get(i).size() == 1){
                return i;
            }
        }
        return 1;
    }
}
