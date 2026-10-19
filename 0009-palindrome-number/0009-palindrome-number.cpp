class Solution {
public:
    bool isPalindrome(int x) {
        long long temp=x;
        if(x<0) return false;
        long long n=0;
        while(x>0){
            int digit=x%10;
            n=n*10+digit;
            x/=10;
        }
        if(n==temp){
            return true;
        }
        else{
            return false;
        }
    }
};