// Problem Statement - Leetcode 1207 - https://leetcode.com/problems/unique-number-of-occurrences

// My Solution

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(map.containsKey(arr[i]) == false){
                map.put(arr[i], 1);
            }
            else{
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(Integer i : map.keySet()){
            if(set.contains(map.get(i)) == true){
                return false;
            }
            set.add(map.get(i));
        }
        return true;
    }
}
