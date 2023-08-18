// problem statement - leetcoe 1615 https://leetcode.com/problems/maximal-network-rank/description/

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int r = roads.length;
        ArrayList<HashSet<Integer>> graph = createGraph(n, roads , r);
        int ans = 0;
        int[] vis = new int[n];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> diffNetwork = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                vis[i] = 1;
                q.add(i);
                temp.add(i);
                while(q.size() != 0){
                    int curr = q.remove();
                    for(Integer nbr: graph.get(curr)){
                        if(vis[nbr] ==0){
                            vis[nbr] = 1;
                            q.add(nbr);
                            temp.add(nbr);
                        }
                    }                    
                }
                int tempAns = 0;
                int currMax = 0;
                for(int j=0; j< temp.size(); j++){
                    int city = temp.get(j);                    
                    tempAns = graph.get(city).size();
                    currMax = Math.max(currMax, tempAns);
                    for(int k=0; k< temp.size(); k++){
                        if(k!= j){
                            int otherCity = temp.get(k);
                            int otherCityAns = graph.get(temp.get(k)).size();
                            int innerAns = tempAns + otherCityAns;
                            if(graph.get(city).contains(otherCity) == true){
                                innerAns -= 1;
                            }
                            if(ans < innerAns){
                                ans = innerAns;
                            }
                        }
                    }                    
                }
                diffNetwork.add(currMax);
                temp = new ArrayList<>();
            }
        }
        Collections.sort(diffNetwork);
        // ans = ans-1;
        if(diffNetwork.size() >= 2){
            if(ans < diffNetwork.get(diffNetwork.size()-1) + diffNetwork.get(diffNetwork.size()-2)){
                ans = diffNetwork.get(diffNetwork.size()-1) + diffNetwork.get(diffNetwork.size()-2);
            }
        }
        return ans;
    }

    ArrayList<HashSet<Integer>> createGraph(int n, int[][] roads, int r){
        ArrayList<HashSet<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new HashSet<>());
        }
        for(int i=0; i<r; i++){
            int city1 = roads[i][0];
            int city2 = roads[i][1];
            graph.get(city1).add(city2);
            graph.get(city2).add(city1);
        }
        return graph;
    }
}
