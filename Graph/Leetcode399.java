// Problem Statement - Leetcode 399 - https://leetcode.com/problems/evaluate-division/

// My Solution 

class Solution {

    private static class Node {
        private final String number;
        private final double weight;

        public Node(String x, double y){
            number = x;
            weight = y;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int totalEquations = equations.size();
        Map<String, List<Node>> numberMap = createMap(equations, totalEquations, values);
        int totalQueries = queries.size();
        double[] divArray = new double[totalQueries];
        for(int i=0; i<totalQueries; i++){
            List<String> query = queries.get(i);
            String start = query.get(0);
            String destination = query.get(1);
            if(!numberMap.containsKey(start) || !numberMap.containsKey(destination)){
                divArray[i] = -1.0;
                continue;
            } else {
                if(start.equals(destination)){
                    divArray[i] = 1.0;
                    continue;
                } else {
                    divArray[i] = findInMap(start, destination, numberMap);
                }
            }
        }
        return divArray;
    }

    private double findInMap(String start, String destination, Map<String, List<Node>> numberMap){
        Map<String, Double> visitedNumber = new HashMap<>();
        Queue<Node> queueSource = new LinkedList<>();
        queueSource.add(new Node(start, 1.0));
        while(queueSource.size() > 0){
            Node sourceNode = queueSource.remove();
            visitedNumber.put(sourceNode.number, sourceNode.weight);
            List<Node> adjList = numberMap.get(sourceNode.number);
            for(int i=0; i< adjList.size(); i++){
                Node currNode = adjList.get(i);
                if(currNode.number.equals(destination)){
                    return sourceNode.weight * currNode.weight;
                } else {
                    if(visitedNumber.containsKey(currNode.number)){
                        continue;
                    } else {
                        queueSource.add(new Node(currNode.number, currNode.weight * sourceNode.weight));
                    }
                }
            }
        }
        return -1.0;
    }

    private Map<String, List<Node>> createMap(List<List<String>> equations, int totalEquations, double[] values){
        Map<String, List<Node>> numberMap = new HashMap<>();
        for(int i=0; i<totalEquations; i++){
            List<String> equation = equations.get(i);
            String numerator = equation.get(0);
            String denominator = equation.get(1);
            if(numberMap.containsKey(numerator)){
                numberMap.get(numerator).add(new Node(denominator, values[i]));
            } else {
                List<Node> tempList = new ArrayList<>();
                tempList.add(new Node(denominator, values[i]));
                numberMap.put(numerator, tempList);
            }
            if(numberMap.containsKey(denominator)){
                numberMap.get(denominator).add(new Node(numerator, 1 / values[i]));
            } else {
                List<Node> tempList = new ArrayList<>();
                tempList.add(new Node(numerator, 1 / values[i]));
                numberMap.put(denominator, tempList);
            }
        }
        return numberMap;
    }
}
