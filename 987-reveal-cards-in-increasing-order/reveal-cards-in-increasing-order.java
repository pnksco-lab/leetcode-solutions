class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            q.add(i);
        }

        int[] result = new int[n];

        for(int card: deck){
            int slotindex = q.remove();
            result[slotindex] = card;

            if(!q.isEmpty()){
                q.add(q.remove());
            }
        }
        return result;
    }
}