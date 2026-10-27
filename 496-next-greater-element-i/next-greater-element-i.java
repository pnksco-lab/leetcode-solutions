class Solution {
    private int findIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; 
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        int nxtgreater [] = new int[nums2.length];
        

        for(int i = nums2.length -1; i >=0 ; i--){
            while(!s.isEmpty() && s.peek() <= nums2[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nxtgreater[i] = -1;
            }else{
                nxtgreater[i] = s.peek();
            }
            s.push(nums2[i]);
        }


        int[] ans = new int[nums1.length];
        for(int j = 0 ; j < nums1.length ; j++){

            int indexnums2 = findIndex(nums2,nums1[j]);
            ans[j] = nxtgreater[indexnums2];
            
        }
        return ans;
        
    }
}