class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if (n <= 1) {
            return n;
        }
        int convert = 0;
        int i = 0;
        // char current = chars[0];
        while (i < n) {
            int count = 1;
            while (i + count < n && chars[i + count] == chars[i]) {
                count++;
            }
            chars[convert++] = chars[i];
            if (count > 1) {
                if (count < 10) {
                    chars[convert++] = (char) (count + '0');
                } else {
                    for (char c : Integer.toString(count).toCharArray()) {
                        chars[convert++] = c;
                    }
                }
            }
            i += count;
        }
        return convert;
    }
}
// 用StringBuilder写的，还是不如char[]
// class Solution {
//     private String convert(int count) {
//         if (count <= 1) {
//             return "";
//         }
//         StringBuilder sb = new StringBuilder();
//         while (count > 0) {
//             sb.insert(0, count % 10);
//             count = count / 10;
//         }
//         return sb.toString();
//     }
//     public int compress(char[] chars) {
//         int n = chars.length;
//         if (n <= 1) {
//             return n;
//         }
//         char current = chars[0];
//         StringBuilder s = new StringBuilder();
//         int count = 1;
//         int ans = 0;
//         for (int i = 1; i < n; i++) {
//             char c = chars[i];
//             if (current == c) {
//                 count++;
//                 continue;
//             }
//             s.append(current);
//             ans++;
//             String tmp = new String();
//             if (count > 1) {
//                 tmp = Integer.toString(count);
//             } else {
//                 tmp = "";
//             }
//             //String tmp = convert(count);
//             s.append(tmp);
//             ans += tmp.length();
//             count = 1;
//             current = c;
//         }
        
//         s.append(current);
//         ans++;
//         String tmp = new String();
//         if (count > 1) {
//             tmp = Integer.toString(count);
//         } else {
//             tmp = "";
//         }
//         // String tmp = convert(count);
//         s.append(tmp);
//         ans += tmp.length();
        
//         tmp = s.toString();
//         for (int i = 0; i < tmp.length(); i++) {
//             chars[i] = tmp.charAt(i);
//         }
//         return ans;
//     }
// }
