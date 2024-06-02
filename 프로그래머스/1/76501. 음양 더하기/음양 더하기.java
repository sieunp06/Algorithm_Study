class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for (int i = 0; i < absolutes.length; i++) {
            boolean sign = signs[i];
            int absolute = absolutes[i];
            
            if (sign) {
                answer += absolute;
                continue;
            }
            answer -= absolute;
        }
        
        return answer;
    }
}