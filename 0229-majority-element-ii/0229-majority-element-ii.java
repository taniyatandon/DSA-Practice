class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map= new HashMap<>();
        int n=nums.length/3;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int key : map.keySet()) {
            if(map.get(key) > n) {
                list.add(key);
            }
        }
        return list;
    }

}