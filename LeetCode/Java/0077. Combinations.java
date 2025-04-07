// Top Interview 150 Backtracking Q1
// class Solution {
//     void backtrack(List<List<Integer>> ans, int n, int k, List<Integer> res) {
//         if (res.size() == k) {
//             ans.add(new ArrayList<>(res));
//             return;
//         }
//         for (int i = res.isEmpty() ? 1 : res.get(res.size() - 1) + 1; i <= n; i++) {
//             res.add(i);
//             backtrack(ans, n, k, res);
//             res.remove(Integer.valueOf(i));
//         }
//     }
//     public List<List<Integer>> combine(int n, int k) {
//         List<List<Integer>> ans = new ArrayList<>();
//         backtrack(ans, n, k, new ArrayList<>());
//         return ans;
//     }
// }

// Daily Challenge 08/01/2023
class Solution {
    void comb(int n, int k, List<List<Integer>> ans, List<Integer> curr) {
        if (n < k) {
            return ;
        }
        if (k == 0) {
            // shallow copy, 复制一遍所有的值, 如果是primitive就等于deep
            // deep copy, 如果是对象, 则还要复制一份对象
            ans.add(new ArrayList<>(curr));
            return ;
        }
        if (n == 0) {
            return;
        }
        curr.add(n);
        comb(n - 1, k - 1, ans, curr);
        curr.remove(curr.size() - 1);
        comb(n - 1, k, ans, curr);
        return ;        
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        comb(n, k, ans, new ArrayList<>());
        return ans;
    }
}
// beat 99% 方法:
//  带着要加入的list进行recursion

// 尝试改进
// class Solution {
//     List<List<Integer>> comb(int n, int k) {
//         List<List<Integer>> ans = new ArrayList<List<Integer>>();
//         if (k > n) {
//             return ans;
//         }
//         // if (k == n) {
//         //     // List<Integer> a = new ArrayList<>();
//         //     // for (int i = 1; i <= n; i++) {
//         //     //     a.add(i);
//         //     // }
//         //     ans.add(a);
//         //     return ans;
//         // }
//         if (k == 1) {
//             // for (int i = 1; i <= n; i++) {
//             //     // 直接List.of()是unmutable
//             //     List<Integer> a = new ArrayList<>(List.of(i));
//             //     ans.add(a);
//             // }
//             if (n == 1) {
//                 ans.add(new ArrayList<>(List.of(1)));
//             } else {
//                 ans = comb(n - 1, 1);
//                 ans.add(new ArrayList<>(List.of(n)));
//             }
//             return ans;
//         }
//         List<List<Integer>> c1 = comb(n - 1, k - 1);
//         for (List<Integer> l : c1) {
//             l.add(n);
//             ans.add(l);
//         }
//         List<List<Integer>> c2 = comb(n - 1, k);
//         ans.addAll(c2);
//         return ans;
        
//     }
//     public List<List<Integer>> combine(int n, int k) {
//         return comb(n, k);
//     }
// }

// Cnk = C(n - 1)(k - 1) + C(n - 1)(k)

// class Solution {
//     List<List<Integer>> comb(int n, int k) {
//         List<List<Integer>> ans = new ArrayList<List<Integer>>();
//         if (k == n) {
//             List<Integer> a = new ArrayList<>();
//             for (int i = 1; i <= n; i++) {
//                 a.add(i);
//             }
//             ans.add(a);
//             return ans;
//         }
//         if (k == 1) {
//             for (int i = 1; i <= n; i++) {
//                 // 直接List.of()是unmutable
//                 List<Integer> a = new ArrayList<>(List.of(i));
//                 ans.add(a);
//             }
//             return ans;
//         }
//         List<List<Integer>> c1 = comb(n - 1, k - 1);
//         for (List<Integer> l : c1) {
//             l.add(n);
//             ans.add(l);
//         }
//         List<List<Integer>> c2 = comb(n - 1, k);
//         ans.addAll(c2);
//         return ans;
        
//     }
//     public List<List<Integer>> combine(int n, int k) {
//         return comb(n, k);
//     }
// }
