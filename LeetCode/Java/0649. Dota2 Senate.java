// LeetCode 75 Queue Q2
class Solution {
    public String predictPartyVictory(String senate) {
        char[] ch = senate.toCharArray();
        int n = ch.length;
        boolean r = true, d = true;
        int count = 0;
        while (r && d) {
            r = false;
            d = false;
            // 关键在此: count要继承上一轮的,这样保证后面的可以投票ban前面的
            // count = 0;
            for (int i = 0; i < n; i++) {
                switch (ch[i]) {
                    case 'R':
                        r = true;
                        if (count < 0) {
                            ch[i] = 0;
                        }
                        count++;
                        break;
                    case 'D':
                        d = true;
                        if (count > 0) {
                            ch[i] = 0;
                        }
                        count--;
                }
            }
        }
        if (r) return "Radiant";
        return "Dire";
    }
}
// better idea:
//  1.用r和d两个boolean记录本次更新是否有各方出现
//  2.在输入上操作,被覆盖了就赋值一个别的,例如0, 但是n <= 10^4 ,用queue可以更快么?
//  3.用一个count来记录操作

// naive simulation
// 贪心: 都ban自己之后的最靠前的对手
//  例如RDDRDR, 第2个D应该ban最后的R, 因为前面的R投票过了. 这样D才能赢,否则是R赢
// class Solution {
//     public String predictPartyVictory(String senate) {
//         LinkedList<Character> q = new LinkedList<>();
//         // LinkedList<Character> p = new LinkedList<>();
//         for (char c : senate.toCharArray()) {
//             q.add(c);
//         }
//         int count = 0;
//         int len = q.size() + 1;
//         while (len > q.size()) {
//             len = q.size();
//             for (int i = 0; i < q.size(); i++) {
//                 char s = q.removeFirst();
//                 switch (s) {
//                     case 'R':
//                         if (count >= 0) {
//                             q.add(s);
//                         }
//                         count++;
//                         break;
//                     case 'D':
//                         if (count <= 0) {
//                             q.add(s);
//                         }
//                         count--;
//                         break;
//                 }
//             }
//         }
//         switch (q.getFirst()) {
//             case 'R':
//                 return "Radiant";
//             case 'D':
//                 return "Dire";
//         }
//         return "";
//     }
// }
