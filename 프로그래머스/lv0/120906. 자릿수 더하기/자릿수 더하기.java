class Solution {
    public int solution(int n) {
        int answer = 0;
        String num = Integer.toString(n);
        char[] numArray = num.toCharArray();
        
        for (char x : numArray) {
            answer += x - '0';
        }
        return answer;
    }
}