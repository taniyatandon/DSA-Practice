class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans= new int[2];
        int[][] arr= new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        int i=0;
        int end=nums.length-1;
        while(i<end){
            int sum=arr[i][0]+arr[end][0];
            if(sum==target){
                ans[0]=arr[i][1];
                ans[1]=arr[end][1];
                return ans;
            }else if(sum<target){
                i++;
            }else{
                end--;
            }
        }
        return new int[]{-1,-1};
    }
}