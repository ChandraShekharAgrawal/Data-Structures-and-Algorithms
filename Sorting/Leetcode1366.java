// Problem Statement - Leetcode 1366 - https://leetcode.com/problems/rank-teams-by-votes/

// My Solution - Java

class Solution {
    public String rankTeams(String[] votes) {
        int voters = votes.length;
        int positions = votes[0].length();
        // prepare counter of each position
        int[][] positionCounter = new int[26][positions + 1];
        for(int i=0; i<26; i++){
            positionCounter[i][positions] = i;
        }
        for(int i=0; i<voters; i++){
            String currVoter = votes[i];
            for(int j=0; j< positions; j++){
                char curr = currVoter.charAt(j);
                positionCounter[curr-'A'][j]++;
            }
        }
        Arrays.sort(positionCounter, (o1, o2) -> {
            for(int i=0; i< positions; i++){
                if(o1[i] > o2[i]){
                    return -1;
                } else if(o1[i] < o2[i]){
                    return 1;
                } else {
                    continue;
                }
            }
            if(o1[positions] < o2[positions]){
                return -1;
            }
            return 1;
        });
        StringBuilder winner = new StringBuilder();
        for(int i= 0; i<positions; i++){
            winner.append((char)(positionCounter[i][positions] + 'A'));
        }
        return winner.toString();
    }
}
