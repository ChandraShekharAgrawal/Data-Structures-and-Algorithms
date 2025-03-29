// Problem Statement - Leetcode 146 - https://leetcode.com/problems/lru-cache/

// My Solution - Java

class LRUCache {
    class DoublyLinkedNode{
        int value;
        int key;
        DoublyLinkedNode previousNode;
        DoublyLinkedNode nextNode;
    }

    private final Map<Integer, DoublyLinkedNode> keyMap;
    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;
    private final int maxSize;

    public LRUCache(int capacity) {
        keyMap = new HashMap<>();
        maxSize = capacity;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        // search in map
        if(keyMap.containsKey(key)){
            DoublyLinkedNode foundNode = keyMap.get(key);
            moveNodeToHead(foundNode);
            return foundNode.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(keyMap.containsKey(key)){
            DoublyLinkedNode foundNode = keyMap.get(key);
            foundNode.value = value;
            moveNodeToHead(foundNode);
        } else {
            if(keyMap.size() < maxSize){
                addNodeToMapAndList(key, value);
            } else {
                // remove node from map and list
                DoublyLinkedNode nodeToRemove = tail;
                keyMap.remove(nodeToRemove.key);

                DoublyLinkedNode prevToRemove = nodeToRemove.previousNode;
                if(prevToRemove != null){
                    prevToRemove.nextNode = null;
                }
                nodeToRemove.previousNode = null;
                tail = prevToRemove;

                // add value to map and list
                addNodeToMapAndList(key, value);
            }
        }
    }

    private void moveNodeToHead(DoublyLinkedNode currNode){
        if(currNode == head){
            return;
        }
        DoublyLinkedNode prevNode = currNode.previousNode;
        if(currNode == tail){
            tail = prevNode;
        }
        if(prevNode != null){
            prevNode.nextNode = currNode.nextNode;
            if(currNode.nextNode != null){
                currNode.nextNode.previousNode = prevNode;
            }
            currNode.previousNode = null;
            currNode.nextNode = head;
            head.previousNode = currNode;
            head = currNode;
        }
    }

    private void addNodeToMapAndList(int key, int value){
        DoublyLinkedNode currNode = new DoublyLinkedNode();
        currNode.value = value;
        currNode.key = key;
        if(keyMap.size() == 0){
            head = currNode;
            tail = currNode;
            
        } else{
            currNode.nextNode = head;
            head.previousNode = currNode;
            head = currNode;
        }
        keyMap.put(key, currNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
