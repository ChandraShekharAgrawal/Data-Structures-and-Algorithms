// Problem Statement - Leetcode 1106 - https://leetcode.com/problems/parsing-a-boolean-expression

// My Solution

class Solution {
    public boolean parseBoolExpr(String expression) {
        int expressionLength = expression.length();
        Stack<Character> charStack = new Stack<>();
        for(int i=0; i< expressionLength; i++){
            char ch = expression.charAt(i);
            if(ch != ')'){
                charStack.add(ch);
            } else{
                int countOfT = 0;
                int countOfF = 0;
                while(charStack.size() > 0 && charStack.peek() != '('){
                    if(charStack.peek() == ','){
                        charStack.pop();
                    } else if (charStack.peek() == 'f') {
                        countOfF++;
                        charStack.pop();
                    } else{
                        countOfT++;
                        charStack.pop();
                    }
                }
                charStack.pop();
                if(charStack.peek() == '!'){
                    if(countOfT > 0){
                        countOfT = 0;
                        countOfF = 1;
                        charStack.pop();
                        charStack.add('f');
                    } else {
                        countOfT = 1;
                        countOfF = 0;
                        charStack.pop();
                        charStack.add('t');
                    }
                } else if (charStack.peek() == '&'){
                    if(countOfF > 0){
                        countOfT = 0;
                        countOfF = 1;
                        charStack.pop();
                        charStack.add('f');
                    } else{
                        countOfT = 1;
                        countOfF = 0;
                        charStack.pop();
                        charStack.add('t');
                    }
                } else{
                    if(countOfT > 0){
                        countOfT = 1;
                        countOfF = 0;
                        charStack.pop();
                        charStack.add('t');
                    } else {
                        countOfT = 0;
                        countOfF = 1;
                        charStack.pop();
                        charStack.add('f');
                    }
                }
            }
        }
        if(charStack.peek() == 't'){
            return true;
        }
        return false;
    }
}
