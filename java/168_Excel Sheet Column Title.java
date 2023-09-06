// Daily Challenge 08/22/2023
// class Solution {
//     public String convertToTitle(int x) {
//        StringBuilder sb = new StringBuilder();
//         while (x > 0) {
//             int r = x % 26;
//             if (r == 0) {
//                 r = 26;
//                 x = x / 26 - 1;
//             } else {
//                 x = x / 26;
//             }
//             sb.insert(0, (char)('A' + r - 1));
//         }
//         return sb.toString();
//     }
// }
class Solution {
    public String convertToTitle(int x) {
       StringBuilder sb = new StringBuilder();
        while (x > 0) {
            x--;
            int r = x % 26;
            // sb.insert(0, (char)('A' + r));
            sb.append((char)('A' + r));
            x = x / 26;
        }
        return sb.reverse().toString();
    }
}
