class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>result = new ArrayList<>();
        List<Integer>current = new ArrayList<>();
        int index = 0;
        Arrays.sort(candidates);
        backtrack(candidates , target , result , current ,index);
        return result;
    }
    void backtrack(int[] candidates, int target,List<List<Integer>>result,List<Integer>current,int index){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return ;
        }
        if(target < 0){
            return;
        }
        
    
        for(int i = index ; i < candidates.length ; i++){
            if (candidates[i] > target) { //for break if the index > than the target like 10 > target 
             break;
            }
            if(i > index && candidates[i] == candidates[i - 1]) {
            continue;     //for skiping the duplicate which lies in the sme level of the recursion 
            }else{ // use for the add the element and the recusion calls and removing
            current.add(candidates[i]);
            backtrack(candidates , target - candidates[i],result , current ,i+1);
            current.remove(current.size()-1);
            }
        }
    }
}