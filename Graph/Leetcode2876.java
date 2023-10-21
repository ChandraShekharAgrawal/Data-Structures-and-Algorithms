// Problem Statement - Leetcode 2876 - https://leetcode.com/problems/count-visited-nodes-in-a-directed-graph

// My Solution

class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        int[] inDegree = new int[n];
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            inDegree[edges.get(i)]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inDegree[i]== 0){
                q.add(i);
            }
        }
        Stack<Integer> notCycle = new Stack<>();
        // finding cycle
        while(q.size()!=0){
            int currNode = q.remove();
            notCycle.add(currNode);
            inDegree[edges.get(currNode)]--;
            if(inDegree[edges.get(currNode)] == 0){
                q.add(edges.get(currNode));
            }
        }
        // add length for cycle elements
        int[] vis = new int[n];
        for(int i=0; i<n; i++){
            if(inDegree[i] != 0 && vis[i] == 0){
                findCycleLength(edges, vis, i, i, ans);
                int count = 0;
                for(int j=0; j<n; j++){
                    if(vis[j] == i){
                        count++;
                    }
                }
                for(int j=0; j<n; j++){
                    if(vis[j] == i){
                        ans[j] = count;
                    }
                }
            }
        }
        // add length for not cycle elements
        
        while(notCycle.size()!=0){
            int node = notCycle.pop();
            ans[node] = ans[edges.get(node)] + 1;
        }
        return ans;
    }

    void findCycleLength(List<Integer> edges, int[] vis, int start, int node, int[] ans){
        if(vis[start] == node){
            return;
        }
        vis[start] = node;
        findCycleLength(edges, vis, edges.get(start), node, ans);
    }
}
