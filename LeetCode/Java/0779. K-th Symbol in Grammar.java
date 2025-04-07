// Daily Question 10/25/2023
class Solution {
    int computeParity(int x) {
        for (int i = 16; i >= 1; i >>= 1) {
            x ^= x >> i;
        }
        return x & 1;
    }
    public int kthGrammar(int n, int k) {
        return computeParity(k - 1);
    }
}
// [Ming]
//  Math solution, the number of 1s in the k - 1 is the number of changes.
//  So the parity of bit count is the answer. 

// [Ming] after see recursion solution. 
//  In this problem, k odd means not change, even means change. 
//  parity parent result
//  0      0      1
//  1      1      1
//  0      1      0
//  1      0      0
// class Solution {
//     public int kthGrammar(int n, int k) {
//         if (k == 1) {
//             return 0;
//         }
//         return 1 - (k & 1) ^ kthGrammar(n, (k + 1) >> 1);
//     }
// }
