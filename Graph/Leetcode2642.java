// Problem Statement - Leetcode 2642 - https://leetcode.com/problems/design-graph-with-shortest-path-calculator

// My Solution

class Graph {

    class Node{
        int node;
        int weight;
        Node(int x, int y){
            node = x;
            weight= y;
        }
    }

    private ArrayList<ArrayList<Node>> graph;

    public Graph(int n, int[][] edges) {
        graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            graph.get(edges[i][0]).add(new Node(edges[i][1], edges[i][2]));
        }
    }
    
    public void addEdge(int[] edge) {
        graph.get(edge[0]).add(new Node(edge[1], edge[2]));
    }
    
    public int shortestPath(int node1, int node2) {
        int[] vis = new int[graph.size()];
        int[] dist = new int[graph.size()];
        for(int i=0; i<dist.length; i++){
            dist[i] = -1;
        }
        dist[node1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.weight < o2.weight){
                return -1;
            }
            return 1;
        });
        pq.add(new Node(node1, 0));
        while(pq.size() != 0){
            Node currNode = pq.remove();
            if(vis[currNode.node] == 0){
                vis[currNode.node] = 1;
                dist[currNode.node] = currNode.weight;
                for(int i=0; i< graph.get(currNode.node).size(); i++){
                    pq.add(new Node(graph.get(currNode.node).get(i).node, graph.get(currNode.node).get(i).weight + currNode.weight));
                }
            }
        }
        return dist[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
