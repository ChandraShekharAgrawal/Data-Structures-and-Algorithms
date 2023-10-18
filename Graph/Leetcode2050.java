// Problem Statement - Leetcode 2050 - https://leetcode.com/problems/parallel-courses-iii

// My Solution

class Solution {

    class Course{
        int courseId;
        int timeFinish;
        Course(int x, int y){
            courseId = x;
            timeFinish = y;
        }
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<Integer> dependencyArray = new ArrayList<>();
        ArrayList<Integer> timeComplete = new ArrayList<>();
        createGraph(graph, n, relations, dependencyArray, timeComplete);
        Queue<Course> q = new LinkedList<>();        
        for(int i=1; i<=n; i++){
            if(dependencyArray.get(i) == 0){
                q.add(new Course(i,0));
            }
        }
        bfs(graph, q, dependencyArray, timeComplete, time, n);
        int ans = timeComplete.get(1);
        for(int i=2; i<=n; i++){
            ans = Math.max(ans, timeComplete.get(i));
        }
        return ans;
    }

    void bfs(ArrayList<ArrayList<Integer>>graph, Queue<Course>q, ArrayList<Integer>dependencyArray, ArrayList<Integer>timeComplete, int[] time, int n){
        while(q.size()!=0){
            Course temp = q.remove();
            timeComplete.set(temp.courseId, Math.max(time[temp.courseId - 1] + temp.timeFinish, timeComplete.get(temp.courseId)));
            ArrayList<Integer> tempDependent = graph.get(temp.courseId);
            for(int i=0; i<tempDependent.size(); i++){
                dependencyArray.set(tempDependent.get(i), dependencyArray.get(tempDependent.get(i)) -1);
                timeComplete.set(tempDependent.get(i), Math.max(timeComplete.get(tempDependent.get(i)), timeComplete.get(temp.courseId)));
                if(dependencyArray.get(tempDependent.get(i)) == 0){
                    q.add(new Course(tempDependent.get(i), timeComplete.get(tempDependent.get(i))));
                }
            }
        }
    }

    void createGraph(ArrayList<ArrayList<Integer>> graph, int n, int[][] relations, ArrayList<Integer> dependencyArray, ArrayList<Integer>timeComplete){
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
            dependencyArray.add(0);
            timeComplete.add(0);
        }
        for(int i=0; i<relations.length; i++){
            dependencyArray.set(relations[i][1], dependencyArray.get(relations[i][1])+1);
            graph.get(relations[i][0]).add(relations[i][1]);
        }
    }
}
