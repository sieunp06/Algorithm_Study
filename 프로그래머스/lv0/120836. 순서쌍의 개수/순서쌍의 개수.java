class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int quo = n / i;
            if (i * quo == n) answer ++;
        }
        return answer;
    }
}