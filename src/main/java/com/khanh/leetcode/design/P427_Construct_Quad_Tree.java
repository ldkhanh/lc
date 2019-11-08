package com.khanh.leetcode.design;

/**
 * @url https://leetcode.com/problems/construct-quad-tree/
 *
 * We want to use quad trees to store an N x N boolean grid. Each cell in the grid can only be true or false. The root node represents the whole grid. For each node, it will be subdivided into four children nodes until the values in the region it represents are all the same.
 *
 * Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val attribute for a leaf node contains the value of the region it represents.
 *
 * Your task is to use a quad tree to represent a given grid. The following example may help you understand the problem better:
 *
 * Given the 8 x 8 grid below, we want to construct the corresponding quad tree:
 *
 *
 *
 * It can be divided according to the definition above:
 *
 *
 *
 *
 *
 * The corresponding quad tree should be as following, where each node is represented as a (isLeaf, val) pair.
 *
 * For the non-leaf nodes, val can be arbitrary, so it is represented as *.
 *
 *
 *
 * Note:
 *
 * N is less than 1000 and guaranteened to be a power of 2.
 * If you want to know more about the quad tree, you can refer to its wiki.
 */

public class P427_Construct_Quad_Tree {

    public Node construct(int[][] grid) {
        if (grid.length == 0) return null;
        return partialConstruct(grid, 0, grid[0].length - 1, 0, grid.length - 1);
    }

    public Node partialConstruct(int[][] grid, int x1,int x2, int y1, int y2){
        //base case
        if ((x1 == x2) && (y1 == y2)){
            boolean current = (grid[y1][x1] == 1);
            return new Node(current ,true, null, null, null, null);//;
        }

        Node topLeft = partialConstruct(grid,x1,((x2-x1)/2)+x1, y1, ((y2-y1)/2)+y1);
        Node topRight = partialConstruct(grid,((x2-x1)/2)+x1+1,x2, y1, ((y2-y1)/2)+y1);
        Node bottomLeft = partialConstruct(grid,x1,((x2-x1)/2)+x1, ((y2-y1)/2)+y1+1, y2);
        Node bottomRight = partialConstruct(grid,((x2-x1)/2)+x1+1,x2, ((y2-y1)/2)+y1+1, y2);


        if (topLeft.isLeaf && topRight.isLeaf && bottomRight.isLeaf && bottomLeft.isLeaf && (topLeft.val == topRight.val) && (topRight.val == bottomRight.val) && (bottomRight.val == bottomLeft.val))
        {
            return new Node(topLeft.val, true, null, null, null, null);
        }
        else{
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node(){}

    public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}