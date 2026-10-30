class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();
        int count = 0;
        for(int i = 0 ; i < num.length() ; i++){
            char ch = num.charAt(i);
            while(!s.isEmpty() && s.peek() > ch && count < k){
                s.pop();
                count++;
            }
            s.push(ch);
        }
        while(count < k && !s.isEmpty()){
            s.pop();
            count++;
        }
        // 2. Reconstruct the string from the stack
        StringBuilder sb = new StringBuilder();
        for (char ch : s) {
            // Skip leading zeros
            if (sb.length() == 0 && ch == '0') {
                continue;
            }
            sb.append(ch);
        }
        
        // 3. If the string is empty, return "0"
        return sb.length() == 0 ? "0" : sb.toString();
    }
}