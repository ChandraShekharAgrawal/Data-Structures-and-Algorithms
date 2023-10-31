// Problem Statement - Leetcode 207 - https://leetcode.com/problems/course-schedule

// My Solution

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i< prerequisites.length; i++){
            inDegree[prerequisites[i][0]]++;
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                pq.add(i);
            }
        }
        boolean[] courses = new boolean[numCourses];
        while(pq.size()!=0){
            int currCourse = pq.remove();
            courses[currCourse] = true;
            for(int i=0; i<graph.get(currCourse).size(); i++){
                inDegree[graph.get(currCourse).get(i)]--;
                if(inDegree[graph.get(currCourse).get(i)] == 0){
                    pq.add(graph.get(currCourse).get(i));
                }
            }
        }
        boolean ans = true;
        for(int i=0; i< numCourses; i++){
            if(courses[i] == false){
                ans = false;
                break;
            }
        }
        return ans;
    }
}
