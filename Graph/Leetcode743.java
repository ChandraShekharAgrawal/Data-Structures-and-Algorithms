// Problem Statement - Leetcode 743 - https://leetcode.com/problems/network-delay-time

// My Solution

class Solution {

    class Node{
        int dist;
        int val;
        Node(int x, int y){
            dist = x;
            val = y;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        createGraph(graph, n, times);
        int[] visited = new int[n+1];
        for(int i=0; i<=n; i++){
            visited[i] = -1;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) ->{
            return o1.dist - o2.dist;
        });
        pq.add(new Node(0, k));
        while(pq.size()!= 0){
            Node currNode = pq.remove();
            if(visited[currNode.val] == -1){
                visited[currNode.val] = currNode.dist;
            }
            else{
                visited[currNode.val] = Math.min(visited[currNode.val], currNode.dist);
            }
            ArrayList<Node> adjList = graph.get(currNode.val);
            for(int i=0; i<adjList.size(); i++){
                if(visited[adjList.get(i).val] == -1){
                    pq.add(new Node(currNode.dist + adjList.get(i).dist, adjList.get(i).val));
                }
                else{
                    if(currNode.dist + adjList.get(i).dist < visited[adjList.get(i).val]){
                        pq.add(new Node(currNode.dist + adjList.get(i).dist, adjList.get(i).val));
                    }
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            if(visited[i] == -1){
                return -1;
            }
            ans = Math.max(ans, visited[i]);
        }
        return ans;
    }

    void createGraph(ArrayList<ArrayList<Node>> graph, int n , int[][] times){
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<times.length; i++){
            graph.get(times[i][0]).add(new Node(times[i][2], times[i][1]));
        }
    }
}
