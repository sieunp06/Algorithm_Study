class Solution {
    public boolean solution(int x) {
        int total = 0;
        for (char num: String.valueOf(x).toCharArray()) {
            total += num - '0';
        }
        
        if (x % total == 0) {
            return true;
        }
        return false;
    }
}