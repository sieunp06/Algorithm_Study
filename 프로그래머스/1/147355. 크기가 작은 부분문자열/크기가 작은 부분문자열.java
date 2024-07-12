class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int start = 0; int end = start + p.length();
        long target = Long.parseLong(p);
        while (end <= t.length()) {
            long num = Long.parseLong(t.substring(start, end));
            if (num <= target) {
                answer++;
            }
            start++; end++;
        }
        return answer;
    }
}