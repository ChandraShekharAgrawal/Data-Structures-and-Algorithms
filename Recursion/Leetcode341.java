// Problem Statement - Leetcode 341 - https://leetcode.com/problems/flatten-nested-list-iterator

// My Solution

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> ans;
    private int nextIndex;

    public NestedIterator(List<NestedInteger> nestedList) {
        ans = new ArrayList<>();       
        nextIndex = 0;
        ans = flattenList(nestedList);        
    }

    private List<Integer>flattenList(List<NestedInteger>nestedList){
        List<Integer> flatList = new ArrayList<>();
        for(NestedInteger nestedInt : nestedList){
            if(nestedInt.isInteger() == true){
                flatList.add(nestedInt.getInteger());
            }
            else{
                List<Integer> nextList = flattenList(nestedInt.getList());
                int i = 0;
                while(nextList.size() > 0 && i<nextList.size()){
                    flatList.add(nextList.get(i));
                    i++;
                }
            }
        }       
        
        return flatList;
    }

    @Override
    public Integer next() {        
        return ans.get(nextIndex++);        
    }

    @Override
    public boolean hasNext() {
        if(ans!= null && nextIndex < ans.size()){
            return true;
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
