class Solution {
    public boolean isPalindrome(int x) {
        long temp=x;
        if(x<0) return false;
        long n=0;
        while(x>0){
            int digit=x%10;
            n=n*10+digit;
            x/=10;
        }
        if(n==temp){
            return true;
        }
        return false;
    }
}