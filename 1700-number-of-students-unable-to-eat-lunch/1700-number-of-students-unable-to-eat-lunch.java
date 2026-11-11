class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        int count = 0;
        for(int i = 0 ; i< students.length ; i++){
            q.add(students[i]);
        }
        for(int i = sandwiches.length-1 ; i >= 0 ; i--){
            s.push(sandwiches[i]);
        }

        while(!q.isEmpty()  && !s.isEmpty()){
            if(q.peek() == s.peek()){
                q.remove();
                s.pop();
                count =0;
            }else{
                q.add(q.remove());
                count++;
            }
            if(count == q.size()){
                break;
            }
        }
        return q.size();
        
    }
}