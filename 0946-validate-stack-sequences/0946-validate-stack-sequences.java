class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int j = 0;

        for (int num : pushed) {

            // Push the current element
            stack.push(num);

            // Pop whenever the top matches popped[j]
            while (!stack.isEmpty() && j < popped.length
                    && stack.peek() == popped[j]) {

                stack.pop();
                j++;
            }
        }

        // If all elements were popped successfully
        return stack.isEmpty();
    }
}