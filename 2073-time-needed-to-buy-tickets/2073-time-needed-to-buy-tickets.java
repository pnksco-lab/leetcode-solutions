class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> q = new LinkedList<>();
        int res = 0;
        
        for(int i = 0 ; i < tickets.length ; i++){
            q.add(new int[]{i , tickets[i]});
        }

        while(!q.isEmpty()){
            int [] curr = q.remove();

            curr[1]--;
            res++;

            if(curr[0] == k && curr[1] == 0){
                return res;
            }
            if(curr[1] > 0){
                q.add(curr);
            }
        }
        return res;
    }
}