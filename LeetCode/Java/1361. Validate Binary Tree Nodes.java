// Daily Question 10/17/2023
class Solution {
    int[] father;
    // Right union find function. 
    int find(int x) {
        if (father[x] != x) {
            father[x] = find(father[x]);
        }
        return father[x];
    }
    // This find function makes the process really slow.
    // Totally wrong union find. 
    // Looks goot to find father[x] but do not assign proper father on the path.
    // int slowFind(int x) {
    //     int f = father[x];
    //     while (f != father[f]) {
    //         f = father[f];
    //     }
    //     father[x] = f;
    //     return f;
    // }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        if (leftChild.length < n || rightChild.length < n) {
            return false;
        }
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        int roots = n;
        for (int i = 0; i < n; i++) {
            if (leftChild[i] == -1) {
                continue;
            }
            if (father[leftChild[i]] != leftChild[i] || find(i) == leftChild[i]) {
                return false;
            }
            father[leftChild[i]] = i;
            roots--;
        }
        for (int i = 0; i < n; i++) {
            if (rightChild[i] == -1) {
                continue;
            }
            if (father[rightChild[i]] != rightChild[i] || find(i) == rightChild[i]) {
                return false;
            }
            father[rightChild[i]] = i;
            roots--;
        }
        // Use roots to count #roots in the forest. 
        // Each connect from parent to child will remove 1 root, which is the child. 
        // This is a better way to count if there is only root left. 
        // int f = find(0);
        // for (int i = 1; i < n; i++) {
        //     if (f != find(i)) {
        //         return false;
        //     }
        // }
        return roots == 1;
    }
}
// [Ming] Using unionfind. But implemented a really bad practice. 
//  [Editorial] Using a count var to track #roots. 

// [Editorial]
//  Use HashSet to find the roots, which are numbers not in the two child arrays. 
//  (Can also use indegree to find roots).
//  And dfs/bfs from root to check. 
