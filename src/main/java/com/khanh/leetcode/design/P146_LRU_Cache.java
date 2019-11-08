package com.khanh.leetcode.design;

/**
 * @url https://leetcode.com/problems/lru-cache/
 *
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2); // capacity
 *
 *cache.put(1,1);
 *cache.put(2,2);
 *cache.get(1);       // returns 1
 *cache.put(3,3);    // evicts key 2
 *cache.get(2);       // returns -1 (not found)
 *cache.put(4,4);    // evicts key 1
 *cache.get(1);       // returns -1 (not found)
 *cache.get(3);       // returns 3
 *cache.get(4);       // returns 4
 *
 *
 */

import java.util.HashMap;
class P146_LRU_Cache {

    private DLinkedNode head, tail;
    private int count, capacity;
    HashMap<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();

    public P146_LRU_Cache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.post = tail;
        tail.pre = head;
        head.pre = null;
        tail.post = null;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;
        this.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DLinkedNode();
            node.value = value;
            node.key = key;
            this.addNode(node);
            this.cache.put(key, node);

            if (++count > capacity) {
                DLinkedNode tailN = this.popTail();
                this.cache.remove(tailN.key);
                count--;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }
    // Define Double Linked List Data structure
    class DLinkedNode {
        int key, value;
        DLinkedNode pre, post;
    }

    private void addNode(DLinkedNode node) {
        node.pre = head;        // add new node right after head
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    private void remove(DLinkedNode node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    private void moveToHead(DLinkedNode node) {
        this.remove(node);
        this.addNode(node);
    }
    private DLinkedNode popTail() {
        DLinkedNode tailN = tail.pre;
        this.remove(tailN);
        return tailN;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */