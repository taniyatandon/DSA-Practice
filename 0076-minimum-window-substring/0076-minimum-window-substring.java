class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> mp=new HashMap<>();
        HashMap<Character,Integer> window=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        if(t.length()>s.length())return "";
        int have=0;
        int required=mp.size();
        int left=0;
        int[] best=new int[]{Integer.MAX_VALUE,0,0};
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            window.put(ch,window.getOrDefault(ch,0)+1);
            if(mp.containsKey(ch) && window.get(ch).equals(mp.get(ch))){
                have++;
            }
            while(have==required){
                if(right-left+1<best[0]) best=new int[]{right-left+1,left,right};
                char l=s.charAt(left++);
                window.put(l,window.getOrDefault(l,0)-1);
                if(mp.containsKey(l) && window.get(l)<mp.get(l)){
                    have--;
                }
            }
        }
        return best[0]==Integer.MAX_VALUE?"":s.substring(best[1],best[2]+1);
    }
}