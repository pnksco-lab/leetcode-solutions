import java.util.Stack;
class StockSpanner {
    Stack<Integer> s;
    Stack<Integer> spans;

    public StockSpanner() {
        s = new Stack<>();
        spans = new Stack<>();
    }
    
    public int next(int price) {
        int currentSpan = 1;

        while (!s.isEmpty() && s.peek() <= price) {
            s.pop();
            currentSpan += spans.pop();
        }

        s.push(price);
        spans.push(currentSpan);

        return currentSpan;
    }
}

// class StockSpanner {

//     public StockSpanner() {
//         Stack<Integer> s = new Stack<>();
//         int[] span = new int[price.length];
//     }
    
//     public int next(int price) {
        
//         span[0] = 1;
//         s.push(0);

//         for(int i = 1; i < price.length ; i++){
//             int currprice = price[i];
//             while(!s.isEmpty() && currprice > price[s.peek()]){
//                 s.pop();
//             }
//             if(s.isEmpty()){
//                 span[i] = i+1;
//             } 
//             else{
//                 int prevhigh = s.peek();
//                 span[i] = i - prevhigh;
//             }
//             s.push(i);
//         }
//     }
// }

// /**
//  * Your StockSpanner object will be instantiated and called as such:
//  * StockSpanner obj = new StockSpanner();
//  * int param_1 = obj.next(price);
//  */