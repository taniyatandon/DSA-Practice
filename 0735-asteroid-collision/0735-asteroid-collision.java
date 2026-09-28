class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        st.push(asteroids[0]);

        for(int i=1;i<asteroids.length;i++){
            if(asteroids[i]<0){
                while(!st.isEmpty() && st.peek()>=0 && Math.abs(st.peek())<Math.abs(asteroids[i])){
                    st.pop();
                }

                if(!st.isEmpty() && st.peek()==Math.abs(asteroids[i])){
                    st.pop();
                }else if(st.isEmpty() || st.peek()<0){
                    st.push(asteroids[i]);
                }
            }else{
                st.push(asteroids[i]);
            }
        }

        int[] arr=new int[st.size()];
        int i=st.size()-1;

        while(!st.isEmpty()){
            arr[i--]=st.pop();
        }

        return arr;
    }
}
