class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] arr= new int[nums1.length];
        Arrays.fill(arr,-1);
        for(int i=0;i<nums1.length;i++){
            Stack<Integer> st=new Stack<>();
            for(int j=nums2.length-1;j>=0;j--){
             while(!st.isEmpty() && nums2[j]>=st.peek()){
                st.pop();
             }
            if(nums2[j] == nums1[i]){
                    if(!st.isEmpty()){
                        arr[i] = st.peek();
                    }
                break;
            }

             st.push(nums2[j]);
            }
        }
        return arr;
    }
}