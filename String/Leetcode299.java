// Problem Statement - Leetcode299 - https://leetcode.com/problems/bulls-and-cows

// My Solution

class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int[] sCount = new int[10];
        int[] tCount = new int[10];
        int bull = 0;
        for(int i=0; i<n; i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bull++;
            }
            else{
                sCount[secret.charAt(i) - '0']++;
                tCount[guess.charAt(i) - '0']++;
            }
        }
        int cow = 0;
        for(int i=0; i<10; i++){
            if(sCount[i]!=0 && tCount[i] != 0){
                cow+= Math.min(sCount[i], tCount[i]);
            }
        }
        return "" + bull + "A" + cow + "B";
    }
}
