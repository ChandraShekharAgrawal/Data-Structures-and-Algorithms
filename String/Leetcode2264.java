// Problem Statement - Leetcode 2264 - https://leetcode.com/problems/largest-3-same-digit-number-in-string

// My Solution

class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        StringBuilder ans = new StringBuilder();
        int count = 0;
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<n; i++){
            if(count == 0){
                temp.append(num.charAt(i));
                count++;
            }
            else if(count < 3 && num.charAt(i) == num.charAt(i-1)){
                temp.append(num.charAt(i));
                count++;
                if(count == 3){
                    if(ans.length() == 0 || ans.charAt(0) < temp.charAt(0) ){
                        while(ans.length() > 0){
                    ans.deleteCharAt(ans.length()-1);
                }
                        for(int j=0; j<3; j++){
                            ans.append(temp.charAt(j));
                        }      
                    }
                }
            }
            else{
                count = 1;
                // int tempLength = temp.length();
                // for(int j=0; j<tempLength; j++){
                //     temp.deleteCharAt(j);
                // }
                while(temp.length() > 0){
                    temp.deleteCharAt(temp.length()-1);
                }
                temp.append(num.charAt(i));
                //temp = null;
            }
            //System.out.println(temp.toString());
        }
        return ans.toString();
    }
}
