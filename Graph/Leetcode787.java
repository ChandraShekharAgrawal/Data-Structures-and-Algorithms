// Problem Statement - Leetcode 787 - https://leetcode.com/problems/cheapest-flights-within-k-stops

// My Solution

import java.util.*;

class Solution {
    class Node{
        int dest;
        int price;
        public Node(int x, int y){
            this.dest = x;
            this.price = y;
        }
    }

    class QNode{
        int dest;
        int price;
        int hops;
        public QNode(int x, int y, int z){
            this.dest = x;
            this.price = y;
            this.hops = z;
        }
    }

    static private int distance;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        createGraph(graph, n, flights);
        distance = 1000 * 1000 * 10;
        PriorityQueue<QNode> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.price - o2.price;
        });
        pq.add(new QNode(src, 0, 0));
        int[] stops = new int[n];
        Arrays.fill(stops, 101);
        updateDistance(dst, k, graph, stops, pq);
        if(distance == 10000000){
            return -1;
        }
        return distance;
    }

    private void updateDistance(int dest, int k, ArrayList<ArrayList<Node>> graph, int[] stops, PriorityQueue<QNode>pq){
        while(pq.size() > 0){
            QNode currNode = pq.remove();

            if(currNode.hops > stops[currNode.dest] ||  currNode.hops > k+1){
                continue;
            }

            stops[currNode.dest] = currNode.hops;

            if(currNode.dest == dest){
                distance = Math.min(distance, currNode.price);
            }
            
            ArrayList<Node> adjList = graph.get(currNode.dest);

            for(int i=0; i<adjList.size(); i++){
                Node tempNode = adjList.get(i);
                pq.add(new QNode(tempNode.dest, currNode.price + tempNode.price, currNode.hops + 1));
            }
        }
    }

    private void createGraph(ArrayList<ArrayList<Node>> graph, int cities, int[][] flights){
        for(int i=0; i<cities; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<flights.length; i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int price = flights[i][2];
            graph.get(src).add(new Node(dest, price));
        }
    }
}
