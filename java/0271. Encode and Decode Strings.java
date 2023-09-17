// Weekly Premium August 2023 W2
// public class Codec {

//     // Encodes a list of strings to a single string.
//     public String encode(List<String> strs) {
//         StringBuilder sb = new StringBuilder();
//         for (String s : strs) {
//             sb
//                 .append((char) s.length())
//                 .append('#')
//                 .append(s);
//         }
//         return sb.toString();
//     }

//     // Decodes a single string to a list of strings.
//     public List<String> decode(String s) {
//         List<String> ans = new ArrayList<>();
//         int n = s.length();
//         int i = 0;
//         while (i < n) {
//             int len = (int) s.charAt(i++);
//             ans.add(s.substring(i + 1, i + len + 1));
//             i += len + 1;
//         }
//         return ans;
        
//     }
// }
//  用一个char表示长度, 算是技巧了, 如果长度很长, 不适合

// length encode
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb
                .append(s.length())
                .append('#')
                .append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        int i = 0;
        int len = 0;
        while (i < n) {
            if (Character.isDigit(s.charAt(i))) {
                len = len * 10 + s.charAt(i) - '0';
                i++;
                continue;
            }
            ans.add(s.substring(i + 1, i + len + 1));
            i += len + 1;
            len = 0;
        }
        return ans;
    }
}

// escape
// public class Codec {

//     // Encodes a list of strings to a single string.
//     public String encode(List<String> strs) {
//         int n = strs.size();
//         StringBuilder sb = new StringBuilder();
//         for (String s : strs) {
//             // char[] ch = s.toCharArray();
//             // for (char c : ch) {
//             //     if (c == '/') {
//             //         sb.append("//");
//             //     } else {
//             //         sb.append(c);
//             //     }
//             // }
//             // sb.append("/:");
//             sb.append(s.replace("/", "//")).append("/:");
//         }
//         return sb.toString();
//     }

//     // Decodes a single string to a list of strings.
//     public List<String> decode(String s) {
//         char[] ch = s.toCharArray();
//         List<String> ans = new ArrayList<>();
//         StringBuilder sb = new StringBuilder();
//         boolean escape = false;
//         for (char c : ch) {
//             switch (c) {
//                 case '/':
//                     if (escape) {
//                         sb.append(c);
//                         escape = false;
//                     } else {
//                         escape = true;
//                     }
//                     break;
//                 case ':':
//                     if (escape) {
//                         ans.add(sb.toString());
//                         sb.setLength(0);
//                         escape = false;
//                     } else {
//                         sb.append(c);    
//                     }
//                     break;
//                 default:
//                     sb.append(c);
//             }
//         }
//         return ans;
//     }
// }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
