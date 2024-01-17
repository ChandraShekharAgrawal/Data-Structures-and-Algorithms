// Problem Statement - Leetcode 2225 - https://leetcode.com/problems/find-players-with-zero-or-one-losses

// My Solution

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int totalMatches = matches.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> losers = new HashMap<>();
        for(int i=0; i<totalMatches; i++){
            if(losers.containsKey(matches[i][1]) == false){
                losers.put(matches[i][1], 1);
            }
            else{
                losers.put(matches[i][1], losers.get(matches[i][1]) + 1);
            }
        }
        HashSet<Integer> winnersZeroLose = new HashSet<>();
        for(int i=0; i<totalMatches; i++){
            if(losers.containsKey(matches[i][0]) == false){
                winnersZeroLose.add(matches[i][0]);
            }
        }
        List<Integer> oneLose = new ArrayList<>();
        for(Integer i: losers.keySet()){
            if(losers.get(i) == 1){
                oneLose.add(i);
            }
        }
        Collections.sort(oneLose);
        List<Integer> zeroLose = new ArrayList<>();
        for(Integer i: winnersZeroLose){
            zeroLose.add(i);
        } 
        Collections.sort(zeroLose);
        ans.add(zeroLose);
        ans.add(oneLose);
        return ans;
    }
}
