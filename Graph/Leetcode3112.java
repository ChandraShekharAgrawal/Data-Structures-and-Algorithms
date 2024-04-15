// Problem Statement - Leetcode 3112 - https://leetcode.com/problems/minimum-time-to-visit-disappearing-nodes/

// My Solution

class Solution {
    class Node{
        int node;
        int weight;
        
        public Node(int x, int y){
            this.node = x;
            this.weight = y;
        }
    }
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        createGraph(graph, n, edges);
        
        int[] vis = new int[n];
        for(int i=0; i<n; i++){
            vis[i] = 0;   
        }
        
        int[] dist = new int[n];
        for(int i=0; i<n; i++){
            dist[i] = -1;
        }
        
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
            return o1.weight - o2.weight;
        });
        
        queue.add(new Node(0, 0));
        
        while(queue.size() != 0){
            Node currNode = queue.remove();
            if(vis[currNode.node] == 0){
                vis[currNode.node] = 1;
                dist[currNode.node] = currNode.weight;
                
                
                int adjSize = graph.get(currNode.node).size();
                ArrayList<Node> adjList = graph.get(currNode.node);
                for(int i=0; i< adjSize; i++){
                    Node tempNode = adjList.get(i);
                    if(vis[tempNode.node] == 0){
                        int tempTime = currNode.weight + tempNode.weight;
                        if(tempTime < disappear[tempNode.node])
                            queue.add(new Node(tempNode.node, tempTime));
                    }
                }
            }            
        }
        
        int[] minTime = new int[n];
        for(int i=1; i<n; i++){
            if(dist[i] == -1 || dist[i] >= disappear[i]){
                minTime[i] = -1;
            }
            else{
                minTime[i] = dist[i];
            }
        }
        return minTime;
    }
    
    void createGraph(ArrayList<ArrayList<Node>>graph, int n, int[][] edges){
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        int totalEdge = edges.length;
        for(int i=0; i< totalEdge; i++){
            int start = edges[i][0];
            int end = edges[i][1];
            int weigh = edges[i][2];
            graph.get(start).add(new Node(end, weigh));
            graph.get(end).add(new Node(start, weigh));
        }
    }
}
