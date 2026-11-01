class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[temperatures.length];
        int n = temperatures.length;

        for(int i = 0 ; i < n ; i++ ){
            int nums = temperatures[i];
            while(!s.isEmpty() && temperatures[s.peek()] < nums){
                int prev = s.pop();

                ans[prev] = i - prev;
            }
            s.push(i);
        }
        return ans;
    }
}
