class Solution {
    private class Pair {
        private char chara;
        private int pos;
        Pair() {};
        Pair(char c, int i) {
            this.chara = c;
            this.pos = i;
        }
        public char getChara() {
            return this.chara;
        }
        public int getPos() {
            return this.pos;
        }
        public void putPos(int i) {
            this.pos = i;
        }
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n <= 2) {
            return n;
        }
        Queue<Pair> pairs = new PriorityQueue<>(
            Comparator.comparingInt((p1) -> p1.getPos()) 
        );
        // Queue<Pair> pairs = new PriorityQueue<>(
        //     Comparator.comparing((p1) -> p1.getPos()) 
        // );
        // 或者自定义comparator<Pair> comp = () - > {};

        char[] cArr = s.toCharArray();
        int ans = 2;
        int left = 0;
        pairs.offer(new Pair(cArr[0], 0));
        for (int right = 1; right < n; right++) {
            char c = cArr[right];
            boolean pop = (pairs.size() == 2);
            for (Pair p : pairs) {
                if (p.getChara() == c) {
                    pairs.remove(p);
                    pop = false;
                    break;
                }
            }
            if (pop) {
                left = pairs.poll().getPos() + 1;
            }
            pairs.offer(new Pair(c, right));
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// 官解的自己实现，用了很笨的PriorityQueue,
// 实际效果感觉不如官方的HashMap和Collections.min()
// remove(cArr[Collections.min(...)])就能去掉了
// 此处感觉消耗差不多,但是hashmap可读性更好一点
// 如果扩展到k个不重复的,删除最小代价太大,每次查k个
// 直接从左边挨个删除反而比较快

// beat 99%的方法:
// 同样,还是不用collection,用数组存char出现freq,用repeat存不同个数
// repeat多于2了, 从左边删起, freq--后如果为0,repeat--

// intuition (&ugly slow)
// class Solution {
//     public int lengthOfLongestSubstringTwoDistinct(String s) {
//         if (s.length() <= 2) {
//             return s.length();
//         }
//         char[] cArr = s.toCharArray();
//         Set<Character> dict = new HashSet<>();
//         int[] idx = new int[128];
//         int left = 0;
//         //int right = left + 1;
//         int ans = 2;
//         dict.add(cArr[0]);
//         idx[cArr[0] - 'A'] = 0;
//         for (int right = 1; right < s.length(); right++) {
//             Character c = cArr[right];
//             idx[c - 'A'] = right;
//             if (dict.size() ==2 && !dict.contains(c)) {
//                 int mostRight = right;
//                 Character removeChar = 127;
//                 for (Character cc : dict) {
//                     if (idx[cc - 'A'] < mostRight) {
//                         mostRight = idx[cc - 'A'];
//                         removeChar = cc;
//                     }
//                 }
//                 left = mostRight + 1;
//                 dict.remove(removeChar);
//             }
//             dict.add(c);
//             ans = Math.max(ans, right - left + 1);
//         }
//         return ans;
//     }
// }
