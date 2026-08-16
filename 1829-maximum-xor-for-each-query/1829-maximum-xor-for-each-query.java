class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {

        int n = nums.length;

        int[] ans = new int[n];

        // Step 1: Create mask
        int mask = (1 << maximumBit) - 1;

        // Step 2: Find XOR of all elements
        int xor = 0;

        for(int num : nums){
            xor = xor ^ num;
        }


        // Step 3: Traverse from end
        for(int i = 0; i < n; i++){

            // Find k to make maximum XOR
            ans[i] = xor ^ mask;

            // Remove last element
            xor = xor ^ nums[n - 1 - i];
        }

        return ans;
    }
}