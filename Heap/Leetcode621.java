// Problem Statement - Leetcode 621 - https://leetcode.com/problems/task-scheduler/

// My Solution

class Solution {

    private class Task{
        private char taskName;
        private int taskCount;

        public Task(char name, int count){
            taskName = name;
            taskCount = count;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int totalTasks = tasks.length;
        int[] charCount = new int[26];
        for(int i=0; i<totalTasks; i++){
            charCount[tasks[i]- 'A']++;
        }
        PriorityQueue<Task> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.taskCount >= o2.taskCount){
                return -1;
            }
            return 1;
        });
        for(int i=0; i<26; i++){
            if(charCount[i] != 0){
                pq.add(new Task((char)(i + 'A') , charCount[i]));
            }
        }
        int remainingTask = totalTasks;
        int minTime = 0;
        while(remainingTask > 0){
            Stack<Task> stack = new Stack<>();
            for(int i=0; i<=n; i++){
                if(remainingTask != 0){
                    if(!pq.isEmpty()){
                        Task peekTask = pq.remove();
                        peekTask.taskCount--;
                        if(peekTask.taskCount != 0)
                            stack.add(peekTask);

                        remainingTask--;
                    }
                    minTime++;
                }
            }
            while(!stack.isEmpty()){
                pq.add(stack.pop());
            }
        }
        return minTime;
    }
}
