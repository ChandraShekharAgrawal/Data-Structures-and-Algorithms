// Problem Statement - Leetcode 2092 - https://leetcode.com/problems/find-all-people-with-secret/ 

// My Solution - good use of multisource bfs and little bit of dijkstra concept

class Solution {
    class Node{
        int person;
        int time;
        public Node(int x, int y){
            person = x;
            time = y;
        }
    }
    
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        createGraph(graph, n, meetings);
        // create an array to record minTime
        int[] minTime = new int[n];
        for(int i=0; i<n; i++){
            minTime[i] = 100001;
        }

        // create queue for bfs
        Queue<Node> q = new LinkedList<>();
        minTime[0] = 0;
        minTime[firstPerson] = 0;
        q.add(new Node(0,0));
        q.add(new Node(firstPerson, 0));
        while(q.size() > 0){
            Node temp = q.remove();
            ArrayList<Node> tempList = graph.get(temp.person);
            for(int i=0; i<tempList.size(); i++){
                if(tempList.get(i).time >= temp.time && tempList.get(i).time < minTime[tempList.get(i).person]){
                    minTime[tempList.get(i).person] = tempList.get(i).time;
                    q.add(new Node(tempList.get(i).person, tempList.get(i).time));
                }
            }
        }

        List<Integer> ansList = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(minTime[i] != 100001){
                ansList.add(i);
            }
        }
        return ansList;
    }

    void createGraph(ArrayList<ArrayList<Node>> graph, int n, int[][] meetings){
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<meetings.length; i++){
            int person1 = meetings[i][0];
            int person2 = meetings[i][1];
            int timeCurr = meetings[i][2];
            graph.get(person1).add(new Node(person2, timeCurr));
            graph.get(person2).add(new Node(person1, timeCurr));
        }
    }
}
