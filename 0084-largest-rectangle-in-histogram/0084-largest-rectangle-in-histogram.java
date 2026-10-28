class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxarea = 0;
        int nsr[] = new int[heights.length];
        int nsl[] = new int[heights.length];
        //nextsmallerright
        Stack<Integer> s = new Stack<>();
        for(int i =heights.length -1 ;i >= 0; i-- ){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }if(s.isEmpty()){
                nsr[i] = heights.length;
            }else{
                nsr[i] =s.peek();
            }
            s.push(i);
        }

        //nextsmallerleft
        s = new Stack<>();
        for(int i =0 ;i < heights.length; i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] =s.peek();
            }
            s.push(i);
        }


        //curretnarea width = j-i-1 = nsr[i] nsl[i]-1
        for(int i = 0 ; i <heights.length ; i++){
            int height = heights[i];
            int width = nsr[i] - nsl[i] -1;
            int currarea = height * width;
            maxarea= Math.max(currarea , maxarea);
        }
        return maxarea;
    }
}