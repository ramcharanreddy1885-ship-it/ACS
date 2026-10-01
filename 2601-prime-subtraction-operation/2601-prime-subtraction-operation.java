class Solution {
    public boolean primeSubOperation(int[] nums) {

        int prev = 0;

        for (int num : nums) {

            int prime = 0;

            // Find the largest prime smaller than num
            for (int p = num - 1; p >= 2; p--) {
                if (isPrime(p) && num - p > prev) {
                    prime = p;
                    break;
                }
            }

            // Subtract the prime if possible
            num = num - prime;

            // If num is not greater than previous value
            if (num <= prev) {
                return false;
            }

            prev = num;
        }

        return true;
    }

    private boolean isPrime(int num) {

        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}