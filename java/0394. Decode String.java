// LeetCode 75 Stack Q3
class Solution {
    // use global var as index
    int idx = 0;
    public String decodeString(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int rep = 0;
        while (idx < n) {
            char c = ch[idx++];
            if (c == ']') {
                return sb.toString();
            }
            if (!Character.isDigit(c)) {
                sb.append(c);
                continue;
            }
            rep = 0;
            while(Character.isDigit(c)) {
                rep = rep * 10 + c - '0';
                c = ch[idx++];
            }
            String res = decodeString(s);
            while (--rep >= 0) {
                sb.append(res);
            }
        }
        return sb.toString();
    }
}
// 用了character.isDigit() 和全局变量, 结构上好很多
// 但是debug用了太久, 不应该

// 很丑的recursion
// class Solution {
//     class MyRes {
//         String str;
//         char[] ch;
//         int idx;
//         MyRes(char[] ch, int idx) {
//             this.ch = ch;
//             this.idx= idx;
//         }
//     }
//     MyRes decode(char[] ch, int index) {
//         int n = ch.length;
//         int idx = index;
//         int rep = 0;
//         StringBuilder sb = new StringBuilder();
//         while (idx < n) {
//             char c = ch[idx];
//             if (c <= '9' && c >= '0') {
//                 rep = rep * 10 + c - '0';
//                 idx++;
//                 continue;
//             }
//             if (c == '[') {
//                 MyRes res = decode(ch, idx + 1);
//                 for (int i = 0; i < rep; i++) {
//                     sb.append(new String(res.ch));
//                 }
//                 rep = 0;
//                 idx = res.idx;
//                 continue;
//             }
//             if (c == ']') {
//                 return new MyRes(sb.toString().toCharArray(), idx + 1);
//             }
//             sb.append(c);
//             idx++;
//         }
//         return new MyRes(sb.toString().toCharArray(), n);
//     }
//     public String decodeString(String s) {
//         MyRes ans = decode(s.toCharArray(), 0);
//         return new String(ans.ch);
//     }
// }
