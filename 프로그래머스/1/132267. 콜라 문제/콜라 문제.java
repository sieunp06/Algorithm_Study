class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
            int cola = n / a;
            n = n - a * cola + b * cola;
            answer += b * cola;
        }
        
        return answer;
    }
}