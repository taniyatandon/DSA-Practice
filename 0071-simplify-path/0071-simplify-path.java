class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < path.length(); i++) {
            if(path.charAt(i) == '/') {
                if(!sb.isEmpty()) {
                    if(sb.toString().equals("..")) {
                        if(!st.isEmpty()) {
                            st.pop();
                        }
                    } else if(!sb.toString().equals(".")) {
                        st.push(sb.toString());
                    }

                    sb.setLength(0);
                }
            } else {
                sb.append(path.charAt(i));
            }
        }

        if(!sb.isEmpty()) {
            if(sb.toString().equals("..")) {
                if(!st.isEmpty()) {
                    st.pop();
                }
            } else if(!sb.toString().equals(".")) {
                st.push(sb.toString());
            }
        }

        StringBuilder ans = new StringBuilder();

        for(String s : st) {
            ans.append("/").append(s);
        }

        return ans.length() == 0 ? "/" : ans.toString();
    }
}