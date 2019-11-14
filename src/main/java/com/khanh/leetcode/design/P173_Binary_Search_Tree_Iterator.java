package com.khanh.leetcode.design;

/**
 * @url https://leetcode.com/problems/binary-search-tree-iterator/
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 *
 *
 * Example:
 *
 *
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 *
 *
 * Note:
 *
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
 *
 */


public class P173_Binary_Search_Tree_Iterator {
    // Space O(1)
    // Ave time : O(1)
    // Morris

    TreeNode current;
    public P173_Binary_Search_Tree_Iterator(TreeNode root) {
        current = root;
    }

    // @return whether we have a next smallest number
    public boolean hasNext() {
        return current != null;
    }

    // @return the next smallest number
    public int next() {
        TreeNode res  = null;
        while (current != null) {       // start travel from current node
            if (current.left == null) {     // in case with left current node is null
                res = current;
                current = current.right;
                break;
            } else {                    // left current node is not null
                TreeNode pre = current.left;
                while (pre.right != null && pre.right != current) { // We go all right most of pre node
                    pre = pre.right;
                }
                if (pre.right == null) {        // in case pre.right node is not current
                    pre.right = current;
                    current = current.left;
                } else {                        // incase of pre.right == current;
                    pre.right = null;
                    res = current;
                    current = current.right;
                    break;
                }
            }
        }
        return (res == null)? - 1 : res.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}