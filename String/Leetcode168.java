// problem statement - Leetcode 168 https://leetcode.com/problems/excel-sheet-column-title/description/

// my solution

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber != 0){
            int rem = columnNumber%26;
            if(rem !=0){
                sb.append((char)('A'+rem-1));
            }
            columnNumber /= 26;
            if(rem == 0){
                sb.append('Z');
                columnNumber--;
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i=sb.length()-1; i>=0; i--){
            ans.append(sb.charAt(i));
        }
        return ans.toString();
    }
}
