// Top Interview 150 Array / String Q23
class Solution {
    int[] nextTable(char[] p) {
        int n = p.length;
        int[] next = new int[n];
        int i = 0, j = 1;
        while (j < n) {
            if (p[i] == p[j]) {
                next[j] = i + 1;
                i++;
                j++;
                continue;
            }
            while (i > 0 && p[i] != p[j]) {
                i = next[i - 1];
            }
            if (p[i] == p[j]) {
                i++;
                next[j] = i;
            }
            j++;
        }
        return next;
    }
    int kmp(String s, String p) {
        int m = s.length(), n = p.length();
        char[] ch = s.toCharArray(), pattern = p.toCharArray();
        int[] lps = nextTable(pattern);
        // System.out.println(Arrays.toString(nextTable("aabaaf".toCharArray())));
        int i = 0, j = 0;
        while (i < m && j < n && m - i >= n - j) {
            if (ch[i] == pattern[j]) {
                i++;
                j++;
                continue;
            }
            while (j > 0 && ch[i] != pattern[j]) {
                j = lps[j - 1];
            }
            if (ch[i] == pattern[j]) {
                j++;
            }
            i++;

        }
        return j == n ? i - n : -1;
    }
    public int strStr(String haystack, String needle) {
        return kmp(haystack, needle);
        // return haystack.indexOf(needle);
    }
}

// KMP: Self Impl, Done!
//  Use lps table, longest-prefix-substring. if [i] !=[j], i = lps[i-1].
//  KMP is for single pattern used for multiple target strings.
//  Especially when pattern has multiple repeats.

// [TODO]BM: Boyer–Moore, same guys for majority votes algo!
//  Wildly used, in JDK, text editors...
//  Match patter reversely.
//  https://oi-wiki.org/string/bm/
//  Bad Character: 
//  Good Prefix:
//  delta1 is how long i needs to shift when mismatch of bad character.
//      easy to build, for each char in dict, it's patLen - 1 - lastIndex[char].
//  delta2 is how long i needs to shift when mismatch of good prefix.


// RK: Hash Method, compare hash first, if match then compare.
//     Use 26 radix digits, like aba -> 121, zzz-> 26 26 26
//     Need MOD for overflow problem.
//  RK is for multiple patterns for single string.
// RK Doubhe Hash: 
//     As shown below, take large mod, collision prob is low.
//     So, bravely take 2 hash and no need to compare.
//     Eg. radix 26 with one prime, and radix 27 with another.

// [RECAP]: Why hash using prime mod?
//   Mostly, input set is not as natural number. May have steps or other distribuitions.
//   A % B = C, A = km, B = kn.
//   km = kn * d + r, then r = kp. The remainder can only be kp.
//   The space from [0, B-1] to [0, p-1] * k. 
//   eg. [0, 5, 10 ,15...] % 10, [0, 5], meaningless, can replace by 2.
//   So chose the prime can fully use the remainder space, reduce collisions.

// [New]: Hash Collision Calculation:
//  N: hash space, k: compute number.
//  never collision: (N-1)/N * (N-2)/N * ... * (N - (k-1))/N
//  aka. 1*(1 - 1/N)*(1 - 2/N)...
//  1 + x ~ e^x, as x->0. Take x = 1/N, 2/N...
//  never: 1*e^(-1/N)*e^(-2/N)... = e^(-k*(k-1)/2N)

//      First collision: Q(H) = sqrt(H * pi/2) // Need more study
//      Resource: https://en.wikipedia.org/wiki/Birthday_attack
