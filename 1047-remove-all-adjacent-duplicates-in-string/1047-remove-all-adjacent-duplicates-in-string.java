class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> ch = new Stack<>();
        
        for(int i = 0; i < s.length() ; i++){
            char curr = s.charAt(i);
            if(!ch.isEmpty() && ch.peek() == curr){
                ch.pop();
            }else{
                ch.push(curr);
            }
        }
        String ans = "";
        
        for (int i = 0; i < ch.size(); i++) {
            char c = ch.get(i);
            ans = ans + c;
        }
        return ans;
    }
}