// Top Interview 150 Array / String Q21
// 08/30/2023
class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        char[] ans = new char[n + 1];
        char[] ch = s.toCharArray();
        int i = n - 1, len = 0;
        while (i >= 0 && ch[i] == ' ') {
            i--;
        }
        while (i >= 0) {
            int right = i;
            while (i >= 0 && ch[i] != ' ') {
                i--;
            }
            for (int j = i + 1; j <= right; j++) {
                ans[len++] = ch[j];
            }
            while (i >= 0 && ch[i] == ' ') {
                i--;
            }
            if (i >= 0) {
                ans[len++] = ' ';
            }
        }
        return new String(ans, 0, len);
    }
}
// beat 99% 的一个思路:
// char[], 从后向前, 找到非空格, 记录坐标为right
// 继续向前,直到空格, 标记为left, 将left到right加入result

// use sb
// class Solution {
//     public String reverseWords(String s) {
//         String[] strArr = s.trim().split("\\s+");
//         int l = strArr.length;
//         StringBuilder result = new StringBuilder();
//         for (int i = l - 1; i >= 0; i--) {
//             result.append(strArr[i]);
//             if (i == 0) {
//                 break;
//             }
//             result.append(" ");
//         }
//         return result.toString();
//         // code below get format like "[blue, is, sky, the]"
//         // Collections.reverse(Arrays.asList(strArr));
//         // return Arrays.toString(strArr);
//     }
// }

// built in:
//   public String reverseWords(String s) {
//     // remove leading spaces
//     s = s.trim();
//     // split by multiple spaces
//     List<String> wordList = Arrays.asList(s.split("\\s+"));
//     Collections.reverse(wordList);
//     return String.join(" ", wordList);
//   }
