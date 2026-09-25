class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();
        if(nums.length==1){
            list.add(nums[0]);
            return list;
        }
        int threshold=nums.length/3;
        int candidate1=nums[0];
        int candidate2=nums[1];
        int count1=0;
        int count2=0;
        for(int i=0;i<nums.length;i++){
            if(candidate1==nums[i]){
                count1++;
            }else if(candidate2==nums[i]){
                count2++;
            }else if(count1==0){
                candidate1=nums[i];
                count1=1;
            }else if(count2==0){
                candidate2=nums[i];
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==candidate1){
                count1++;
            }else if(nums[i]==candidate2){
                count2++;
            }
        }
        if(count1>threshold){
            list.add(candidate1);
        }
        if(candidate2 != candidate1 && count2>threshold){
            list.add(candidate2);
        }
        return list;
    }

}