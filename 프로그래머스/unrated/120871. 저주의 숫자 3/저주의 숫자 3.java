class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = 0;
        
        while (num < n) {
            answer++; num++;
            while (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                answer++;
            }
        }
        
        return answer;
    }
}