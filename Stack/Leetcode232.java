// Problem Statement - Leetcode 232 - https://leetcode.com/problems/implement-queue-using-stacks/

// My Solution

class MyQueue {
    Stack<Integer> pushStack;
    Stack<Integer> removeStack;

    public MyQueue() {
        pushStack = new Stack<>();
        removeStack = new Stack<>();
    }
    
    public void push(int x) {
        pushStack.push(x);
    }
    
    public int pop() {
        if(removeStack.size() == 0){
            while(pushStack.size() != 0){
                int top = pushStack.peek();
                pushStack.pop();
                removeStack.push(top);
            }
        }
        return removeStack.pop();
    }
    
    public int peek() {
        if(removeStack.size() == 0){
            while(pushStack.size() != 0){
                int top = pushStack.peek();
                pushStack.pop();
                removeStack.push(top);
            }
        }
        return removeStack.peek();
    }
    
    public boolean empty() {
        if(pushStack.size() == 0 && removeStack.size() == 0){
            return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
