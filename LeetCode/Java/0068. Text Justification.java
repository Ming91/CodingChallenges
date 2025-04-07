// Top Interview 150 Array / String Q24
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int len = 0;
            int start = i;
            StringBuilder sb = new StringBuilder();
            while (i < n && words[i].length() + len <= maxWidth) {
                len += words[i++].length() + 1;
            }
            int spaceNum = maxWidth - len + (i - start);
            // if single string?
            int spaceWid = 0; // spaceNum / (i - start - 1);
            int spaceRem = 0; // spaceNum % (i - start - 1);
            if (i == n || start + 1 == i) {
                spaceWid = 0;
                spaceRem = spaceNum;
            } else {
                spaceWid = spaceNum / (i - start - 1);
                spaceRem = spaceNum % (i - start - 1);
            }
            for (int j = start; j < i - 1; j++) {
                sb.append(words[j]);
                sb.append(" ".repeat(spaceWid));
                if (spaceRem > 0) {
                    sb.append(" ");
                    spaceRem--;
                }
            }
            sb.append(words[i - 1]);
            sb.append(" ".repeat(spaceRem));
            ans.add(sb.toString());
        }
        return ans;
    }
}

// Daily Challenge 08/24/2023
// class Solution {
//     public List<String> fullJustify(String[] words, int maxWidth) {
//         int i = 0, n = words.length;
//         List<String> ans = new ArrayList<>();
//         int lines = 0;
//         while (i < n) {
//             int space = 0;
//             int len = 0;
//             int start = i;
//             while (i < n && len <= maxWidth - words[i].length()) {
//                 len += words[i].length() + 1;
//                 i++;
//                 space++;    
//             }
            
//             StringBuilder sb = new StringBuilder();
//             if (i == n || start + 1 == i) {
//                 for (int j = start; j < i - 1; j++) {
//                     sb.append(words[j] + " ");
//                 }
                
//                 sb.append(words[i - 1]);
//                 sb.append(" ".repeat(maxWidth - sb.length()));
//                 ans.add(sb.toString());
//                 continue;
//             }
//             space += maxWidth - len;
//             int minSpc = space / (i - start - 1);
//             int remainSpc = space %  (i - start - 1);
//             for (int j = start; j < i - 1; j++) {
//                 sb.append(words[j]);
//                 sb.append(" ".repeat(minSpc));

//                 if (remainSpc > 0) {
//                     sb.append(" ");
//                     remainSpc--;
//                 } 
//             }
//             sb.append(words[i - 1]);
//             sb.append(" ".repeat(remainSpc));
            
//             ans.add(sb.toString());
//         }
//         return ans;
//     }
// }
