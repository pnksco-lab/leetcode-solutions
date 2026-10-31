class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int []answer = new int[temperatures.length];

        for(int i = 0 ; i< temperatures.length ; i++){
            int nums = temperatures[i];
            int count = 0;
            while(!s.isEmpty() && temperatures[s.peek()] < nums){
                int previous = s.pop();

                answer[previous] = i - previous;
            }
            s.push(i);
        }
        return answer;
                
    }
}