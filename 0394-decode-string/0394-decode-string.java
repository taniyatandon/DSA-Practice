class Solution {
    public String decodeString(String s) {
     Stack<Integer> stackInt=new Stack<>();
     Stack<String> st=new Stack<>();
     StringBuilder ans=new StringBuilder();
     int i=0;
     while(i<s.length()){
        if(Character.isDigit(s.charAt(i))){
            int num = 0;
            while(i < s.length() && Character.isDigit(s.charAt(i))){
                num = num * 10 + (s.charAt(i) - '0');
                i++;
            }
            stackInt.push(num);
        }else if(s.charAt(i)=='['){
            st.push(ans.toString());
            ans=new StringBuilder();
            i++;
        }else if(s.charAt(i)==']'){
            int n=stackInt.pop();
            String str=st.pop();
            StringBuilder temp= new StringBuilder();
            for(int j=0;j<n;j++){
                temp.append(ans);
            }
            ans=new StringBuilder(str);
            ans.append(temp);
            i++;
        }else{
            ans.append(s.charAt(i));
            i++;
        }
     }
     return ans.toString();
     
    }
}