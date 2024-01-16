// Problem Statement - Leetcode 380 - https://leetcode.com/problems/insert-delete-getrandom-o1

// My Solution

class RandomizedSet {
    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> array;

    public RandomizedSet() {
        map = new HashMap<>();
        array = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        array.add(val);
        map.put(val, array.size() -1);
        return true;
    }

    public boolean remove(int val) {
        if((map.containsKey(val) != false)){
            int indexToReplace = map.get(val);
            array.set(indexToReplace, array.get(array.size() - 1));
            map.put(array.get(indexToReplace), indexToReplace);
            array.remove(array.size() -1);
            map.remove(val);
            return true; 
        }
        return false;
    }

    public int getRandom() {
        Random random = new Random();
        int indexToReturn = random.nextInt(array.size());
        return array.get(indexToReturn);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
