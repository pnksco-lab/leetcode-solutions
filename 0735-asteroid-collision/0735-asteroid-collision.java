class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        
        
        for(int i = 0 ; i < asteroids.length ; i++){
            int current = asteroids[i];
            boolean survive = true;
            while(!s.isEmpty() && s.peek() > 0 && asteroids[i] < 0){
                
                if(s.peek() > Math.abs(current)){
                    survive = false;
                    break;
                }
                else if(s.peek() == Math.abs(current)){
                    s.pop();
                    survive = false;
                    break;
                }
                else {
                    s.pop();
                }
                
            }
            if(survive){
                s.push(current);
            }
        }
        int[] ans = new int[s.size()];
        for(int i = ans.length -1; i >= 0 ; i--){
            ans[i] = s.pop();
        }
        return ans;

    }
}
