// Problem Solution - Leetcode 823 - https://leetcode.com/problems/binary-trees-with-factors

// My Solution 

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer> arrSet = new HashSet<>();
        int mod = 1000 * 1000 * 1000 + 7;
        for(int i=0; i<arr.length; i++){
            arrSet.add(arr[i]);
        }
        HashMap<Integer, Long> countTree = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            long currAns = findCount(arr[i], arrSet, countTree, mod);
            countTree.put(arr[i], currAns);
        }
        long ans = 0;
        for(Integer i:countTree.keySet()){
            ans += countTree.get(i);
        }
        return (int)(ans%mod);
    }

    long findCount(int num, HashSet<Integer> arrSet, HashMap<Integer, Long> countTree, int mod){
        if(countTree.containsKey(num) == true){
            return countTree.get(num);
        }
        int countDivisor = 0;
        long ans = 0;
        for(int i=2; i*i <= num; i++){
            if(num%i == 0){
                if(i*i == num){
                    if(arrSet.contains(i) == true){
                        ans = (ans + ((countTree.get(i) * countTree.get(i))%mod))%mod;
                    }
                    countDivisor++;
                }
                else{
                    if(arrSet.contains(i)== true && arrSet.contains(num/i) == true){
                        ans = (ans + (((countTree.get(i) * countTree.get(num/i))%mod)*2) )%mod;
                    }
                    countDivisor += 2;
                }
            }
        }
        if(countDivisor == 0){
            return 1;
        }
        return (ans+1)%mod;
    }
}
