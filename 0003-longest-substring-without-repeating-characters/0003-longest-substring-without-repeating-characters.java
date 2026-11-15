class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int max=0;
        HashSet<Character> set= new HashSet<>();
        for(int end=i;end<s.length();end++){
            while(set.contains(s.charAt(end))){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(end));
            max=Math.max(max,end-i+1);
        }
        return max;
    }
}