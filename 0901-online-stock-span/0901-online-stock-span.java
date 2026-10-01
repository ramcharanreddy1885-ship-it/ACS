import java.util.Stack;

class StockSpanner {

    // Stores [price, span]
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {

        int span = 1;

        // Remove all smaller or equal prices
        while (!stack.isEmpty() && stack.peek()[0] <= price) {

            // Add their already calculated span
            span += stack.pop()[1];
        }

        // Store today's price and its span
        stack.push(new int[]{price, span});

        return span;
    }
}