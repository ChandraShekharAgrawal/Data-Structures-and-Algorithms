// Problem Statement - Leetcode 1436 - https://leetcode.com/problems/destination-city

// My Solution

class Solution {
    public String destCity(List<List<String>> paths) {
        int n = paths.size();
        HashMap<String, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            if(mp.containsKey(paths.get(i).get(0)) == false ){
                mp.put(paths.get(i).get(0), 1);
            }
            else{
                mp.put(paths.get(i).get(0), mp.get(paths.get(i).get(0))+1);
            }
            if(mp.containsKey(paths.get(i).get(1)) == false){
                mp.put(paths.get(i).get(1), 1);
            }
            else{
                mp.put(paths.get(i).get(1), mp.get(paths.get(i).get(1))+1);
            }
        }
        String one = "";
        String two = "";
        for(String s: mp.keySet()){
            if(mp.get(s) == 1 && one.length() ==0){
                one = s;
            }
            else if(mp.get(s) == 1 && two.length() ==0){
                two = s;
            }
        }
        for(int i=0; i<n; i++){
            if(paths.get(i).get(1) == one){
                return one;
            }
            if(paths.get(i).get(1) == two){
                return two;
            }
        }
        return "";
    }
}
