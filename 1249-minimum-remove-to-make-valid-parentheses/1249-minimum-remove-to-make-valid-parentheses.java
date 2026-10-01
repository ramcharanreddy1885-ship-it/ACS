import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack<>();
        boolean[] remove = new boolean[s.length()];

        // Step 1: Find invalid parentheses
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(') {
                // Store index of opening bracket
                stack.push(i);
            }

            else if (c == ')') {

                if (!stack.isEmpty()) {
                    // Match with an opening bracket
                    stack.pop();
                } else {
                    // No matching '('
                    remove[i] = true;
                }
            }
        }

        // Step 2: Any '(' remaining in stack is invalid
        while (!stack.isEmpty()) {
            remove[stack.pop()] = true;
        }

        // Step 3: Build the answer
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (!remove[i]) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}