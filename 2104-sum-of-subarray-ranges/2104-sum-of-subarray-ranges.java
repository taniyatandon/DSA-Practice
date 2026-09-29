class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        int left[] = new int[n];
        int right[]= new int[n];
        Stack<Integer> st= new Stack<>();
        long ans=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && (i == n || nums[st.peek()] >nums[i])){
                st.pop();
            }
            left[i]=st.isEmpty()? i+1 : i-st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && (i == n || nums[st.peek()] >= nums[i])){
                st.pop();
            }
            right[i]=st.isEmpty()? n-i : st.peek()-i;
            st.push(i);
        }
        st.clear();
        for(int i=0;i<n;i++){
            ans-=(long)left[i]*right[i]*nums[i];
        }
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && (i == n || nums[st.peek()] < nums[i])){
                st.pop();
            }
            left[i]=st.isEmpty()? i+1 : i-st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && (i == n || nums[st.peek()] <= nums[i])){
                st.pop();
            }
            right[i]=st.isEmpty()? n-i : st.peek()-i;
            st.push(i);
        }
        st.clear();
        for(int i=0;i<n;i++){
            ans+=(long)left[i]*right[i]*nums[i];
        }
        return ans;
    }
}