class Solution {
    public String reverseWords(String s) {
        String[] strArr = s.trim().split("\\s+");
        int l = strArr.length;
        StringBuilder result = new StringBuilder();
        for (int i = l - 1; i >= 0; i--) {
            result.append(strArr[i]);
            if (i == 0) {
                break;
            }
            result.append(" ");
        }
        return result.toString();
        // code below get format like "[blue, is, sky, the]"
        // Collections.reverse(Arrays.asList(strArr));
        // return Arrays.toString(strArr);
    }
}
// beat 99% 的一个思路:
// char[], 从后向前, 找到非空格, 记录坐标为right
// 继续向前,直到空格, 标记为left, 将left到right加入result

// built in:
//   public String reverseWords(String s) {
//     // remove leading spaces
//     s = s.trim();
//     // split by multiple spaces
//     List<String> wordList = Arrays.asList(s.split("\\s+"));
//     Collections.reverse(wordList);
//     return String.join(" ", wordList);
//   }
