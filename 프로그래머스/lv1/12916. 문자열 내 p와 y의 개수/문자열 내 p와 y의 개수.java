class Solution {
    boolean solution(String s) {
        int p_count = 0;
        int y_count = 0;
        for (char x: s.toLowerCase().toCharArray()) {
            if (x == 'p') p_count++;
            if (x == 'y') y_count++;
        }        
        return p_count == y_count ? true:false;
    }
}