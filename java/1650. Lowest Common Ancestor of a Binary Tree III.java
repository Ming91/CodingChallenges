/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node pPtr = p;
        Node qPtr = q;
        //int loop = 0;
        while (pPtr != qPtr) {
            // if (loop > 2) {
            //     return null;
            // }
            pPtr = pPtr.parent;
            qPtr = qPtr.parent;
            if (pPtr == null) {
                pPtr = q;
            //    loop++;
            }
            if (qPtr == null) {
                qPtr = p;
            //    loop++;
            }
        }
        return pPtr;
    }
}
// beat 99%的想法:
// 同时向上找father,如果相同,则返回
// 如果一个到头了,则变为另一个的初始位置
// 这样两个指针,会在同时跑到lca时候相遇,

// 改进: 加上loop,如果pq有不在树里面的,可以检查出来

// intuition idea with set
// 轮流/同时往里加,如果已有,则返回
// class Solution {
//     public Node lowestCommonAncestor(Node p, Node q) {
//         Set<Integer> fathers = new HashSet<>();
//         fathers.add(p.val);
//         fathers.add(q.val);
//         while (p != null && q != null) {
//             Node pf = p.parent;
//             Node qf = q.parent;
//             if (pf == qf) {
//                 return pf;
//             }
//             if (pf == null) {
//                 if (qf == null) {
//                     return null;
//                 }
//                 if (fathers.contains(qf.val)) {
//                     return qf;
//                 }
//                 // fathers.add(qf.val);
//                 q = qf;
//                 continue;
//             }
//             if (qf == null) {
//                 if (fathers.contains(pf.val)) {
//                     return pf;
//                 }
//                 // fathers.add(pf.val);
//                 p = pf;
//                 continue;
//             }
//             if (!fathers.contains(pf.val)) {
//                 fathers.add(pf.val);
//                 p = pf;
//             }
//             if (!fathers.contains(qf.val)) {
//                 fathers.add(qf.val);
//                 q = qf;
//             }
//         }
//         return null;
//     }
// }
