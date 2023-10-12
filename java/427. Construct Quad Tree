// Top Interview 150 Divide & Conquer Q3
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    Node constructWithBound(int[][] grid, int rowL, int colL, int len) {
        if (len == 1) {
            return new Node((grid[rowL][colL] == 1), true);
        }
        int newLen = len >> 1;
        Node topLeft = constructWithBound(grid, rowL, colL, newLen);
        Node topRight = constructWithBound(grid, rowL, colL + newLen, newLen);
        Node bottomLeft = constructWithBound(grid, rowL + newLen, colL, newLen);
        Node bottomRight = constructWithBound(grid, rowL + newLen, colL + newLen, newLen);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
            topLeft.val == topRight.val && topRight.val == bottomLeft.val &&
            bottomLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true);
        }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
    public Node construct(int[][] grid) {
        return constructWithBound(grid, 0, 0, grid.length);
    }
}
// [Editorial]
//  Visit each gird only once, but have more payload. 

// [Ming] This will visit each grid mutiple times. Not efficient. 
// class Solution {
//     Node constructWithBound(int[][] grid, int rowL, int rowR, int colL, int colR) {
//         boolean isLeaf = true;
//         int target = grid[rowL][colL];
//         for (int i = rowL; i < rowR; i++) {
//             for (int j = colL; j < colR; j++) {
//                 if (grid[i][j] != target) {
//                     isLeaf = false;
//                     break;
//                 }
//             }
//         }
//         if (isLeaf) {
//             return new Node((grid[rowL][colL] == 1), true);
//         }
//         Node root = new Node(false, false);
//         int rowMid = (rowL + rowR) / 2;
//         int colMid = (colL + colR) / 2;
//         root.topLeft = constructWithBound(grid, rowL, rowMid, colL, colMid);
//         root.topRight = constructWithBound(grid, rowL, rowMid, colMid, colR);
//         root.bottomLeft = constructWithBound(grid, rowMid, rowR, colL, colMid);
//         root.bottomRight = constructWithBound(grid, rowMid, rowR, colMid, colR);
//         return root;
//     }
//     public Node construct(int[][] grid) {
//         return constructWithBound(grid, 0, grid.length, 0, grid[0].length);
//     }
// }
