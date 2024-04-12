// Problem Statement - Leetcode 1700 - https://leetcode.com/problems/number-of-students-unable-to-eat-lunch

// My Solution

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int totalSandwiches = sandwiches.length;
        Stack<Integer> sandwich = new Stack<>();
        Queue<Integer> student = new LinkedList<>();
        for(int i=0; i< totalSandwiches; i++){
            sandwich.add(sandwiches[totalSandwiches-1-i]);
            student.add(students[i]);
        }

        for(int i=0; i<totalSandwiches; i++){
            if(sandwich.peek() == student.peek()){
                sandwich.pop();
                student.poll();
                continue;
            }
            else{
                int count = student.size();
                while(sandwich.peek() != student.peek()){
                    student.add(student.poll());
                    count--;
                    if(count == 0){
                        return student.size();
                    }
                }
                sandwich.pop();
                student.poll();
            }
        }
        return student.size();
    }
}
