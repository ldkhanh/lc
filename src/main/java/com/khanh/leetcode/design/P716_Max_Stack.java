package com.khanh.leetcode.design;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @url  https://leetcode.com/problems/max-stack/
 *
 * Design a max stack that supports push, pop, top, peekMax and popMax.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Remove the element on top of the stack and return it.
 * top() -- Get the element on the top.
 * peekMax() -- Retrieve the maximum element in the stack.
 * popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
 * Example 1:
 * MaxStack stack = new MaxStack();
 * stack.push(5);
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 * Note:
 * -1e7 <= x <= 1e7
 * Number of operations won't exceed 10000.
 * The last four operations won't be called when stack is empty.
 *
 * Solution:
 *
 *     //  Double Linked List + Tree Map
 *     //  Time O(logN)  Space: O(N)
 *     //  Double Linked List: remove nodes in O(1)
 *     //  TreeMap find largest value, insert values, delete values: O(logN) time.
 *     //  This question similar to LRU Cache
 *
 */
public class P716_Max_Stack {
    // TreeMap store pair<Value, List_of_Node>
    TreeMap<Integer, List<Node>> map;
    DoubleLinkedList dll;
    public P716_Max_Stack() {
        map = new TreeMap<>();
        dll = new DoubleLinkedList();
    }

    public void push(int x) {
        Node node = dll.add(x);
        if (!map.containsKey(x)){
            map.put(x, new ArrayList<Node>());
        }
        map.get(x).add(node);
    }

    public int pop() {
        int val = dll.pop();
        List<Node> L = map.get(val);
        L.remove(L.size()-1);
        if (L.isEmpty()) map.remove(val);
        return val;
    }

    public int top() {
        return dll.peek();
    }

    public int peekMax() {
        return map.lastKey();       // max value key of map
    }

    public int popMax() {
        int maxVal = peekMax();
        List<Node> L = map.get(maxVal);
        Node node = L.remove(L.size() - 1);
        dll.unlink(node);
        if (L.isEmpty()) map.remove(maxVal);
        return maxVal;
    }

    class Node {
        int val;
        Node prev, next;
        public Node(int v) {val = v;}
    }

    class DoubleLinkedList {
        Node head, tail;
        public DoubleLinkedList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }

        // Add to the tail  ==> First In -> Last Out
        public Node add(int val) {
            Node x = new Node(val);
            x.next = tail;
            x.prev = tail.prev;
            tail.prev.next = x;
            tail.prev = x;
            return x;
        }

        public int pop() {      // Last out from Tail
            return unlink(tail.prev).val;
        }

        // add to tail so max point to tail
        public int peek() {
            return tail.prev.val;
        }

        public Node unlink(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }
    }
}


