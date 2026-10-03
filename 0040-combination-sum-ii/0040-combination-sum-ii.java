class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates,0,target,new ArrayList<>(),ans);
        return ans;
    }
    private void solve(int[] arr,int i,int target,List<Integer>list,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i==arr.length || target<0)return;
        for(int j=i;j<arr.length;j++){
            if(j>i && arr[j]==arr[j-1])continue;
            list.add(arr[j]);
            solve(arr,j+1,target-arr[j],list,ans);
            list.remove(list.size()-1);
        }
        
        
    }
}