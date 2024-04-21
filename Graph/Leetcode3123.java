// Problem Statement - Leetcode 3123 - https://leetcode.com/problems/find-edges-in-shortest-paths/

// My Solution

class Solution {

    class Node{
        int dest;
        int weight;
        int edgeIndex;
        public Node(int x, int y, int z){
            dest = x;
            weight = y;
            edgeIndex = z;
        }
    }

    class DistanceNode{
        int distance;
        List<List<Integer>> ansIndexList;

        public DistanceNode(){
            distance = -1;
            ansIndexList = new ArrayList<>();
        }
    }

    class PqNode{
        int distance;
        int src;
        List<Integer> indexList;

//         public PqNode(){

//         }

        public PqNode(int x, int y){
            this.distance = x;
            this.src = y;
            indexList = new ArrayList<>();
        }
    }

    public boolean[] findAnswer(int n, int[][] edges) {
        List<List<Node>> graph = new ArrayList<>();

        createGraph(graph, edges, n);

        int[] vis = new int[n];

        DistanceNode[] distance = new DistanceNode[n];
        for(int i=0; i<n; i++){
            distance[i] = new DistanceNode();
        }

        // create pq for handling nodes
        PriorityQueue<PqNode> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.distance < o2.distance){
                return -1;
            }
            else if(o1.distance > o2.distance){
                return 1;
            }
            else{
                return o1.src - o2.src;
            }
        });


        // add first Node
        for(int i=0; i< graph.get(0).size(); i++){
            Node node = graph.get(0).get(i);
            PqNode pqNode = new PqNode(node.weight, node.dest);
            pqNode.indexList.add(node.edgeIndex);
            pq.add(pqNode);
        }
        vis[0] = 1;

        // traverse pq
        while(pq.size() > 0){
            PqNode pqNode = pq.remove();
            if(vis[n-1] == 1 && pqNode.distance > distance[n-1].distance){
                break;
            }
            // check if Node visited
            if(vis[pqNode.src] == 1){
                if(distance[pqNode.src].distance == pqNode.distance){
//                    distance[pqNode.src].ansIndexList.add()
                    List<Integer> tempIndexList = new ArrayList<>();
                    for(int i=0; i<pqNode.indexList.size(); i++){
                        tempIndexList.add(pqNode.indexList.get(i));
                    }
                    distance[pqNode.src].ansIndexList.add(tempIndexList);
                }

                if(vis[n-1] == 0){
                    List<Node> tempNodeList = graph.get(pqNode.src);
                    for(int i=0; i< tempNodeList.size(); i++){
                        Node tempNode = tempNodeList.get(i);
                        if(vis[tempNode.dest] == 0){
                            PqNode tempPqNode = new PqNode(tempNode.weight + pqNode.distance, tempNode.dest);
                            for(int j=0; j<pqNode.indexList.size(); j++){
                                tempPqNode.indexList.add(pqNode.indexList.get(j));
                            }
                            tempPqNode.indexList.add(tempNode.edgeIndex);
                            pq.add(tempPqNode);
                        }
                    }
                }
            }

            // else
            else{
                vis[pqNode.src] = 1;
                distance[pqNode.src].distance = pqNode.distance;
                List<Integer> tempIndexList = new ArrayList<>();
                for(int i=0; i<pqNode.indexList.size(); i++){
                    tempIndexList.add(pqNode.indexList.get(i));
                }
                distance[pqNode.src].ansIndexList.add(tempIndexList);
                List<Node> tempNodeList = graph.get(pqNode.src);
                for(int i=0; i< tempNodeList.size(); i++){
                    Node tempNode = tempNodeList.get(i);
                    if(vis[tempNode.dest] == 0){
                        PqNode tempPqNode = new PqNode(tempNode.weight + pqNode.distance, tempNode.dest);
                        for(int j=0; j<pqNode.indexList.size(); j++){
                            tempPqNode.indexList.add(pqNode.indexList.get(j));
                        }
                        tempPqNode.indexList.add(tempNode.edgeIndex);
                        pq.add(tempPqNode);
                    }
                }
            }
        }


        boolean[] ans = new boolean[edges.length];
        List<List<Integer>> destIndexList = distance[n-1].ansIndexList;
        for(int i=0; i< destIndexList.size(); i++){
            List<Integer> tempDestIndexList = destIndexList.get(i);
            for(int j=0; j<tempDestIndexList.size(); j++){
                ans[tempDestIndexList.get(j)] = true;
            }
        }
        return ans;
    }

    void createGraph(List<List<Node>> graph, int[][] edges, int n){
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

//        for(int i=0; i<n; i++){
//            graph.get(i).add(new ArrayList<>());
//        }
        for(int i=0; i<edges.length; i++){
            int srcId = edges[i][0];
            int destId = edges[i][1];
            int weight = edges[i][2];

            graph.get(srcId).add(new Node(destId, weight, i));
            graph.get(destId).add(new Node(srcId, weight, i));
        }
    }
}
