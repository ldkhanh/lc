package com.khanh.leetcode.design;

public class BSTIteratorTest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode left0 = new TreeNode(3);
        TreeNode right0 = new TreeNode(15);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        root.left = left0;
        root.right = right0;
        right0.left = left1;
        right0.right = right1;

        P173_Binary_Search_Tree_Iterator itr = new P173_Binary_Search_Tree_Iterator(root);
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
