// Top Interview 150 Stack Q2
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] segments = path.split("/");
        for (String segment : segments) {
            if (segment.isEmpty() || segment.equals(".")) {
                continue;
            }
            if (segment.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.add(segment);
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : stack) {
            sb.append("/").append(str);
        }
        // while (!stack.isEmpty()) {
        //     sb.insert(0, stack.pop());
        //     sb.insert(0, "/");
        // }
        return sb.toString();
    }
}
// Tips: you can iterate stack from bottom using for-loop

// [Ming] Naive Stack Simulation
// class Solution {
//     public String simplifyPath(String path) {
//         Stack<String> stack = new Stack<>();
//         char[] ch = path.toCharArray();
//         int n = path.length();
//         int i = 0;
//         while (i < n) {
//             while (i < n && ch[i] == '/') {
//                 i++;
//             }
//             if (stack.size() == 0 || !stack.peek().equals("/")) {
//                 stack.add("/");
//             }
//             if (i == n) {
//                 break;
//             }
//             var sb = new StringBuilder();
//             while (i < n && ch[i] != '/') {
//                 sb.append(ch[i++]);
//             }
//             if (sb.toString().equals(".")) {
//                 if (stack.size() > 1) {
//                     stack.pop();
//                 }
//                 continue;
//             }
//             if (sb.toString().equals("..")) {
//                 if (stack.size() >= 3) {
//                     stack.pop();
//                     stack.pop();
//                 }
//                 continue;
//             }
//             stack.add(sb.toString());
//         }
//         var sb = new StringBuilder();
//         if (stack.size() > 1 && stack.peek().equals("/")) {
//             stack.pop();
//         }
//         while (!stack.isEmpty()) {
//             sb.insert(0, stack.pop());
//         }
//         return sb.toString();
//     }
// }
