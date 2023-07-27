// Daily Challenge 07/21/2023
class Solution {
    static class Num {
        int val;
        int idx;
        int count;
        Num(int val, int idx) {
            this.val = val;
            this.idx = idx;
            this.count = 0;
        }
        // public void setCount(int count) {
        //     this.count = count;
        // }
    }

    static class Term {
        Num[] cands = new Num[50];
        Num first;
        Num last;
        int size = 0;
        Term() {};
        Term(int val, int idx) {
            add(val, idx);
            first = last;
        };
        void add(int val, int idx) {
            last = new Num(val, idx);
            // learn how to expand
            if (size == cands.length) {
                cands = Arrays.copyOf(cands, size << 1);
            }
            cands[size++] = last;
        }        
    }
    int searchTerm(Term[] seq, int target, int right) {
        int l = 1;
        int r = right;
        while (l < r) {
            int mid = (l + r) >> 1;
            Term term = seq[mid];
            // System.out.println(term.first.val + "," + term.last.val);
            if (term.last.val < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    int searchIdx(Term term, int target) {
        int l = 0;
        int r = term.size - 1;
        Num[] v = term.cands;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (target >= v[mid].idx) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    int searchVal(Term term, int target) {
        int l = 0;
        int r = term.size - 1;
        Num[] v = term.cands;

        // version 1
        // while (l <= r) {
        //     int mid = (l + r) >> 1;
        //     if (target < v[mid].val) {
        //         l = mid + 1;
        //     } else {
        //         r = mid - 1;
        //     }
        // }
        // return r;

        // version 2
        while (l < r) {
            int mid = (l + r) >> 1;
            if (target < v[mid].val) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // since if last element cant tell state
        if (v[l].val > target) {
            return l;
        } else {
            return l - 1;
        }
    }
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        Term[] subSeq = new Term[n + 1];
        int len = 0;
        subSeq[0] = new Term((int)-1e6-1, -1);
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // if larger than the last value in subSeq, add a term
            // remember, last value in each term is the real value in subSeq
            // others are candidates in history for count
            if (num > subSeq[len].last.val) {
                subSeq[++len] = new Term(num, i);
            } else {
                int insertIdx = searchTerm(subSeq, num, len);
                // System.out.println(num + "," + insertIdx);
                subSeq[insertIdx].add(num, i);
            }
        }
        Term lastTerm = subSeq[len];
        for (int i = 0; i < lastTerm.size; i++) {
            // lastTerm.cands[i].count = 1;
            // update to prefix count
            lastTerm.cands[i].count = i + 1;
        }
        // System.out.println();
        for (; len > 0; len--) {
            Term prevTerm = subSeq[len - 1];
            Term currTerm = subSeq[len];
            for (int prevIdx = 0; prevIdx < prevTerm.size; prevIdx++) {
                Num prev = prevTerm.cands[prevIdx];
                // if this number is lager than all numbers in current term
                //                or have idx lager than current term
                //  just skip
                if (prev.val < currTerm.first.val && prev.idx < currTerm.last.idx) {
                    // use prefix need two idx for calculation
                    // think straight here!
                    
                    // statement above make sure have valid idx
                    // first valid idx that curr.idx > prev.idx
                    int startIdx = searchIdx(currTerm, prev.idx);
                    // last valid val that curr.val > prev.val
                    int endIdx = searchVal(currTerm, prev.val);
                    
                    int currCount = 0;
                    if (startIdx <= endIdx) {
                        if (startIdx == 0) {
                            currCount += currTerm.cands[endIdx].count;
                        } else {
                            currCount += currTerm.cands[endIdx].count - currTerm.cands[startIdx - 1].count;
                        }
                    }
                    
                    prev.count += currCount;
                    // System.out.println(prev.val + "," + startIdx + "," + endIdx + "," + prev.count);
                }
                prev.count += prevIdx == 0 ? 0 : prevTerm.cands[prevIdx - 1].count;
                // System.out.println(prev.val + "," + prev.count);
            }
        }
        return subSeq[0].first.count;
    }
}

// how to use methond in problem 300, build subseq?
// 还是一样的思路，但是要复杂很多, 不是简单的subseq, 要记录subseq更新的历史
// 例如[1, 1, 3, 3, 2, 2]
// 要这样记录
// [0] : [1, 1]
// [1] : [3, 3, 2, 2]
// 这样每一位都是一个降序的list, 每列的最后一个组成了原来的subseq
// 对新数i:
//      1. 如果i比currList[last]大, 则新加一位空list, 把i放进去
//      2. 否则, 要更新前面的列, 从左到右看看比哪一位的最后一个数小, 放进去
// 这样subSeq构建完成, 要来计算count了
// 原解法从后向前,从前向后应该也可以,
// 对于目前的list, 和其之前的list比较, 
//  prev里的元素可以当curr的前继 当且仅当 prev的value < curr, 且prev.idx<curr
//  curr里value最大是first, idx最大是last
//  // prev里value最小是last, idx最小是first, 比较一下,如果均不行,则跳过
//      疑问: 根据构造,会这样么? -> 不是整个比较, 是prev每个元素比较
//  然后就对该元素p统计curr里面value>p, idx>p的数量, 加到p的count里
//  这样最后的count就该是第一个list里面count之和,如果定第一位是0,可以直接统计

//  改进：从5ms->4ms, 使用prefix sum, 每个term里的num的count都设置为其后面count之和
//  

// class Solution {
//     static class Num {
//         int val;
//         int idx;
//         int count;
//         Num(int val, int idx) {
//             this.val = val;
//             this.idx = idx;
//             this.count = 0;
//         }
//         // public void setCount(int count) {
//         //     this.count = count;
//         // }
//     }

//     static class Term {
//         Num[] cands = new Num[50];
//         Num first;
//         Num last;
//         int size = 0;
//         Term() {};
//         Term(int val, int idx) {
//             add(val, idx);
//             first = last;
//         };
//         void add(int val, int idx) {
//             last = new Num(val, idx);
//             // learn how to expand
//             if (size == cands.length) {
//                 cands = Arrays.copyOf(cands, size << 1);
//             }
//             cands[size++] = last;
//         }        
//     }
//     int searchTerm(Term[] seq, int target, int right) {
//         int l = 1;
//         int r = right;
//         while (l < r) {
//             int mid = (l + r) >> 1;
//             Term term = seq[mid];
//             // System.out.println(term.first.val + "," + term.last.val);
//             if (term.last.val < target) {
//                 l = mid + 1;
//             } else {
//                 r = mid;
//             }
//         }
//         return l;
//     }
//     int searchIdx(Term term, int target) {
//         int l = 0;
//         int r = term.size - 1;
//         Num[] v = term.cands;
//         while (l < r) {
//             int mid = (l + r) >> 1;
//             if (target >= v[mid].idx) {
//                 l = mid + 1;
//             } else {
//                 r = mid;
//             }
//         }
//         return l;
//     }
//     public int findNumberOfLIS(int[] nums) {
//         int n = nums.length;
//         Term[] subSeq = new Term[n + 1];
//         int len = 0;
//         subSeq[0] = new Term((int)-1e6-1, -1);
//         for (int i = 0; i < n; i++) {
//             int num = nums[i];
//             // if larger than the last value in subSeq, add a term
//             // remember, last value in each term is the real value in subSeq
//             // others are candidates in history for count
//             if (num > subSeq[len].last.val) {
//                 subSeq[++len] = new Term(num, i);
//             } else {
//                 int insertIdx = searchTerm(subSeq, num, len);
//                 // System.out.println(num + "," + insertIdx);
//                 subSeq[insertIdx].add(num, i);
//             }
//         }
//         Term lastTerm = subSeq[len];
//         for (int i = 0; i < lastTerm.size; i++) {
//             lastTerm.cands[i].count = 1;
//         }
//         // System.out.println();
//         for (; len > 0; len--) {
//             Term prevTerm = subSeq[len - 1];
//             Term currTerm = subSeq[len];
//             for (int prevIdx = 0; prevIdx < prevTerm.size; prevIdx++) {
//                 Num prev = prevTerm.cands[prevIdx];
//                 // if this number is lager than all numbers in current term
//                 //                or have idx lager than current term
//                 //  just skip
//                 if (prev.val >= currTerm.first.val || prev.idx >= currTerm.last.idx) {
//                     continue;
//                 }
//                 // two constraint, idx and value, curr.first.val is larger prev,
//                 // so search idx is better
//                 int startIdx = searchIdx(currTerm, prev.idx);
                
//                 int currCount = 0;
//                 for (int j = startIdx; j < currTerm.size && currTerm.cands[j].val > prev.val; j++) {
//                     currCount += currTerm.cands[j].count;
//                 }
//                 prev.count += currCount;
                
//                 // System.out.println(prev.val + "," + startIdx + "," + prev.count);
//             }
//         }
//         return subSeq[0].first.count;
//     }
// }


/**
一下代码思路错误,解题过程中的思考
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> sub = new ArrayList<>();
        List<Integer> lastList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        int count = 1;
        sub.add(nums[0]);
        lastList.add(nums[0]);
        countList.add(1);
        for (int j = 1; j < n; j++) {
            int num = nums[j];
            int size = sub.size();
            int last = sub.get(size - 1);
            if (num > last) {
                sub.add(num);
                int l = 0;
                int r = lastList.size() - 1;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (lastList.get(mid) >= num) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                // System.out.println("last");
                // for (int i = 0; i < lastList.size(); i++) {
                //     System.out.println(lastList.get(i) + "," + countList.get(i));
                // }
                count = 0;
                for (int i = l; i < lastList.size(); i++) {
                    count += countList.get(i);
                }
                lastList.clear();
                lastList.add(num);
                countList.clear();
                countList.add(count);
                continue;
            }
            // [1, 2] add 2, update lastList and countList
            // 当前的last一定是lastList里最后的一个,
            if (num == last) {
                int lastIdx = countList.size() - 1;
                count = countList.get(lastIdx) + 1;
                countList.set(lastIdx, count);
                continue;
            }
            int l = 0;
            int r = size - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (sub.get(mid) < num) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            // if update last, update its count
            if (l == size - 1) {
                lastList.add(num);
                countList.add(1);
                count++;
            }
            sub.set(l, num);
        }
        // System.out.println("sub");
        // for (Integer s : sub) {
        //     System.out.println(s);
        // }
        return count;
    }
}

// smarter way: use problem 300 nlogn method -- build subseq using binary search
// 想法1: 一个sub,更新sub时,如果位置是最后,则count++
//   问题: [3, 1, 2], 2比3小, 此策略出问题.
//     解决: 加个last[], 看看怎么样
//      问题: [1,2,4,3,5,4,7,2]这种, 5继承了43的count2,7又继承了54的,但是这个5里的count是2
//       解决: 加个lastCount[]
//      问题: [2, 1]
//      问题: [1, 1, 1, 3, 3, 2, 2, 2]这种情况,这个办法没用,2已经不知道该继承多少个了
*/

// use editorial version topdown dp
// maybe bottom up faster

// class Solution {
//     private void dfs(int i, int[] nums, int[] len, int[] count) {
//         if (len[i] > 0) {
//             return;
//         }
//         // 这里处理比intuition好
//         // 之前是len和count都赋值1
//         // 但是遇到一个len为1的不知道是没访问过还是更新后为1
//         // 初值设置为0更好记忆和prune
//         len[i] = 1;
//         count[i] = 1;
//         for (int j = 0; j < i; j++) {
//             if (nums[j] < nums[i]) {
//                 dfs(j, nums, len, count);
//                 if (len[i] == len[j]  + 1) {
//                     count[i] += count[j];
//                 }
//                 if (len[i] < len[j] + 1) {
//                     count[i] = count[j];
//                     len[i] = len[j] + 1;
//                 }
//             }
            
//         }
//         return;
//     }
//     public int findNumberOfLIS(int[] nums) {
//         int n = nums.length;
//         int[] len = new int[n];
//         int[] count = new int[n];
//         int maxLen = 0;
//         int maxCount = 0;
//         for (int i = 0; i < n; i++) {
//             dfs(i, nums, len, count);
//             if (len[i] > maxLen) {
//                 maxLen = len[i];
//             }
//         }
//         for (int i = 0; i < n; i++) {
//             if (len[i] == maxLen) {
//                 maxCount += count[i];
//             }
//         }
//         return maxCount;
//     }
// }


// intuition top down
// 记录以i结尾的count和len
// 挨个比较max
// 想法对头，表现不好

// class Solution {
//     int[] len;
//     int[] count;
//     private int dfs(int i, int[] nums) {
//         if (len[i] > 1) {
//             return len[i];
//         }
//         for (int j = 0; j < i; j++) {
//             if (nums[j] < nums[i]) {
//                 int lenJ = dfs(j, nums) + 1;
//                 if (len[i] == lenJ) {
//                     count[i] += count[j];
//                 }
//                 if (len[i] < lenJ) {
//                     len[i] = lenJ;
//                     count[i] = count[j];
//                 }
                
//             }
//         }
//         return len[i];
//     }
//     public int findNumberOfLIS(int[] nums) {
//         int n = nums.length;
//         len = new int[n];
//         count = new int[n];
//         Arrays.fill(len, 1);
//         Arrays.fill(count, 1);
//         int maxLen = -1;
//         int maxCount = 0;
//         for (int i = 0; i < n; i++) {
//             int lenI = dfs(i, nums);
//             if (maxLen == lenI) {
//                 maxCount += count[i];
//             }
//             if (maxLen < lenI) {
//                 //System.out.println(nums[i]);
//                 maxLen = len[i];
//                 maxCount = count[i];
//             }
//         }
//         //System.out.println(maxLen);
//         return maxCount;
//         //return count[n - 1];
//     }
// }