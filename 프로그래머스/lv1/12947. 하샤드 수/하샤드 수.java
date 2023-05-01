class Solution {
    public boolean solution(int x) {
        int num = 0;
        for (char alpha : String.valueOf(x).toCharArray()) 
            num += alpha - '0';
        
        if (x % num == 0) return true;
        return false;
    }
}