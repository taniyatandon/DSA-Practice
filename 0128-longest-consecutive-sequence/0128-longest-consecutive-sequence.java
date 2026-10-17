class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int ans=0;
        for(int value:set){
            if(set.contains(value-1))continue;
            int currLength=1;
            int nextVal=value+1;
            while(set.contains(nextVal)){
                currLength++;
                nextVal++;
            }
            ans=Math.max(ans,currLength);
        }
        return ans;
    }
}