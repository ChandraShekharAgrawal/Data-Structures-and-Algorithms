// Problem Statement - Leetcode 1356 - https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits

// My Solution

class Solution {
    public int[] sortByBits(int[] arr) {
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            arrList.add(arr[i]);
        }
        Collections.sort(arrList, (o1, o2)->{
            int count1 = findSetBits(o1);
            int count2 = findSetBits(o2);
            if(count1 > count2){
                return 1;
            }
            else if(count1 < count2){
                return -1;
            }
            else{
                return o1 - o2;
            }
        });
        int[] sortedArr = new int[arr.length];
        for(int i=0; i< arr.length; i++){
            sortedArr[i] = arrList.get(i);
        }
        return sortedArr;
    }

    int findSetBits(int num){
        int count = 0;
        while(num > 0){
            if((num & 1) > 0){
                count++;
            }
            num = num>>1;
        }
        return count;
    }
}
