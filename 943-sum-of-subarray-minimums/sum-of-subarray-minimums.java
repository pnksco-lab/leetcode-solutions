import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long totalSum = 0;
        int MOD = 1_000_000_007;
        
        // Monotonic Increasing Stack stores indices
        Stack<Integer> s = new Stack<>();

        // We run the loop up to 'n' to process remaining elements at the end
        for (int i = 0; i <= n; i++) {
            // Use 0 or -1 as a dummy element at the end to force pop everything
            int currentVal = (i == n) ? 0 : arr[i];

            // If incoming element is SMALLER, the top element has found its Next Smaller Element!
            while (!s.isEmpty() && arr[s.peek()] > currentVal) {
                int mid = s.pop(); // The element we are calculating subarrays for
                
                // Right boundary index is 'i' (Next Smaller Element)
                // Left boundary index is the new stack top (Previous Smaller Element)
                int leftBoundary = s.isEmpty() ? -1 : s.peek();
                
                long leftCount = mid - leftBoundary;
                long rightCount = i - mid;

                // Contribution of arr[mid] to the total sum
                long contribution = (leftCount * rightCount) % MOD;
                totalSum = (totalSum + (arr[mid] * contribution)) % MOD;
            }
            s.push(i);
        }

        return (int) totalSum;
    }
}
