// Top Interview 150 Stack Q1
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case ')' -> {
                    if (!stack.isEmpty() && stack.peek().equals('(')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                case ']' -> {
                    if (!stack.isEmpty() && stack.peek().equals('[')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                case '}' -> {
                    if (!stack.isEmpty() && stack.peek().equals('{')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                default -> {
                    stack.add(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
