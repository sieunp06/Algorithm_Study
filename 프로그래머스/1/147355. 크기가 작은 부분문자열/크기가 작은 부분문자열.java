class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int start = 0; int end = p.length();
        long target = Long.parseLong(p);
        
        while (end <= t.length()) {
            String text = t.substring(start, end);
            if (Long.parseLong(text) <= target) {
                answer++;
            }
            start++; end++;
        }
        
        return answer;
    }
}