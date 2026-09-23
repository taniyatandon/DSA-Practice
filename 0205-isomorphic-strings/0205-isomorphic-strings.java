class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sToT = new int[128];
        int[] tToS = new int[128];

        Arrays.fill(sToT,-1);
        Arrays.fill(tToS,-1);

        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            char b=t.charAt(i);

            if(sToT[a]!=-1 && sToT[a]!=b){
                return false;
            }

            if(tToS[b]!=-1 && tToS[b]!=a){
                return false;
            }

            sToT[a]=b;
            tToS[b]=a;
        }

        return true;
    }
}