// class Solution {
//     public boolean canJump(int[] nums) {
//         return canReachFrom(0, nums);
//     }

//     private boolean canReachFrom(int currentIndex, int[] nums) {
//         // Base case: Reached or passed the last index
//         if (currentIndex >= nums.length - 1) {
//             return true;
//         }

//         // Calculate the farthest index we can jump to from here
//         int maxJump = Math.min(currentIndex + nums[currentIndex], nums.length - 1);

//         // Try every possible jump length from 1 step up to maxJump
//         for (int nextIndex = currentIndex + 1; nextIndex <= maxJump; nextIndex++) {
//             if (canReachFrom(nextIndex, nums)) {
//                 return true;
//             }
//         }

//         // None of the jump choices led to the end
//         return false;
//     }
// }
class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            // 1. Check if we can even reach the current index i
            if (i > maxReach) {
                return false;
            }

            // 2. Update the farthest index reachable from index i
            maxReach = Math.max(maxReach, i + nums[i]);

            // 3. If we can already reach or pass the last index, return true early
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}
