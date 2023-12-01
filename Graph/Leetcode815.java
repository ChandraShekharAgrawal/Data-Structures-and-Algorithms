// Problem Statement - Leetcode 815 - https://leetcode.com/problems/bus-routes/

// My Solution

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        int n = routes.length;
        HashMap<Integer, ArrayList<Integer>> stop = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<routes[i].length; j++){
                if(stop.containsKey(routes[i][j]) == false){
                    stop.put(routes[i][j], new ArrayList<>());
                }
                stop.get(routes[i][j]).add(i);
            }
        }
        if(stop.containsKey(source) == false || stop.containsKey(target) == false){
            return -1;
        }
        HashSet<Integer> visRoute = new HashSet<>();
        Queue<Integer> qRoute = new LinkedList<>();
        for(int i=0; i<stop.get(source).size(); i++){
            qRoute.add(stop.get(source).get(i));
            visRoute.add(stop.get(source).get(i));
        }
        int buses = 0;
        while(qRoute.size() !=0 ){
            buses++;
            int qRouteSize = qRoute.size();
            for(int i=0; i< qRouteSize; i++){
                int currRoute = qRoute.remove();
                // traversing stops in current route
                for(int busStop: routes[currRoute]){
                    if(busStop == target){
                        return buses;
                    }
                    // add other routes for that stop
                    for(Integer nextRoute: stop.get(busStop)){
                        if(visRoute.contains(nextRoute) == false){
                            qRoute.add(nextRoute);
                            visRoute.add(nextRoute);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
