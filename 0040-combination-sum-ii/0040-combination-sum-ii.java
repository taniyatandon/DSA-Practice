class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private void solve(int i, int[] arr, int target, List<Integer> list, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int j = i; j < arr.length; j++) {
            if(j > i && arr[j] == arr[j - 1]) continue;
            if(arr[j] > target) break;

            list.add(arr[j]);
            solve(j + 1, arr, target - arr[j], list, ans);
            list.remove(list.size() - 1);
        }
    }
}