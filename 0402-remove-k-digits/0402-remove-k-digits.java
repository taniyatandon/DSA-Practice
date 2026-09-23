class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';

            while (k > 0 && !st.isEmpty() && st.peek() > digit) {
                st.pop();
                k--;
            }

            st.push(digit);
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder current = new StringBuilder();

        while (!st.isEmpty()) {
            current.append(st.pop());
        }

        current.reverse();

        while (current.length() > 0 && current.charAt(0) == '0') {
            current.deleteCharAt(0);
        }

        return current.length() == 0 ? "0" : current.toString();
    }
}