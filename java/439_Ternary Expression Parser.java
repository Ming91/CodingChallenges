// Weekly Premium July 2023, W4
class Solution {
    private String search(char[] ch, int idx) {
        // System.out.println(idx);
        char c = ch[idx];
        // case 2: 最后一个,或只有1个, 且为T/F
        // if (idx == n - 1) {
        //     return String.valueOf(c);
        // }
        // case 3: 如果不是一个exp的开头,而是一个返回值
        // 例如是B?T:E2, 那么也返回
        // if (ch[idx + 1] != '?') {
        //     return String.valueOf(c);
        // }
        if (idx == ch.length - 1 || ch[idx + 1] == ':') {
            return String.valueOf(c);
        }

        // case 1: 为digit, 即结果
        // if (c != 'T' && c != 'F') {
        //     return String.valueOf(c);
        // }

        


        // case 4: exp开头,且为真,跳到E1
        if (c == 'T') {
            return search(ch, idx + 2);
        } else {
            // case 5: exp开头, 且为F, 跳到E2
            // 通过匹配?:的数量来完成
            int count = 0;
            idx++;
            do {
                if (ch[idx] == '?') {
                    count++;
                    idx += 2;
                } else {
                    if (ch[idx] == ':') {
                        count--;
                        if (count == 0) {
                            return search(ch, idx + 1);
                        } else {
                            idx += 2;
                        }
                    }
                }
                
            } while (count != 0);
            //System.out.println(idx);
        }
        return "";
    }

    public String parseTernary(String expression) {
        char[] ch = expression.toCharArray();
        return search(ch, 0);
        
    }
}

// beat 99%?: 用do while来合理规划, idx+=2加速搜索.

// editorial self impl
// class Solution {
//     public String parseTernary(String expression) {
//         int idx = 0;
//         int n = expression.length();
//         char[] ch = expression.toCharArray();
//         while (true) {
//             char c = ch[idx];
//             // case 2: 最后一个,或只有1个, 且为T/F
//             // if (idx == n - 1) {
//             //     return String.valueOf(c);
//             // }
//             // case 3: 如果不是一个exp的开头,而是一个返回值
//             // 例如是B?T:E2, 那么也返回
//             // if (ch[idx + 1] != '?') {
//             //     return String.valueOf(c);
//             // }
//             if (idx == n - 1 || ch[idx + 1] == ':') {
//                 return String.valueOf(c);
//             }

//             // case 1: 为digit, 即结果
//             // if (c != 'T' && c != 'F') {
//             //     return String.valueOf(c);
//             // }

            


//             // case 4: exp开头,且为真,跳到E1
//             if (c == 'T') {
//                 idx += 2;
//             } else {
//                 // case 5: exp开头, 且为F, 跳到E2
//                 // 通过匹配?:的数量来完成
//                 int count = 1;
//                 idx += 2;
//                 while (count != 0 && idx < n) {
//                     if (ch[idx] == '?') {
//                         count++;
//                     } else {
//                         if (ch[idx] == ':') {
//                             count--;
//                         }
//                     }
//                     idx++;
                    
//                 }
//                 //System.out.println(idx);
//             }

//         }
        
//     }
// }

// class Solution {
    
//     public String parseTernary(String expression) {
//         Stack<Character> v = new Stack<Character>();
//         int idx = expression.length() - 1;
//         char[] ch = expression.toCharArray();
//         while (idx >= 0) {
//             char c = ch[idx--];
//             switch (c) {
//                 case ':':
//                     continue;
//                 case '?':
//                     char b = ch[idx--];
//                     char el = v.pop();
//                     char er = v.pop();
//                     char res = b == 'T' ? el : er;
//                     v.push(res);
//                     break;
//                 default:
//                     v.push(c);
//             }
//         }
//         return v.pop().toString();
//     }
// }
// T ? T : F ? E1 : E2
// 靠右原则,最右的?前面的一定和其结合,这点很重要
