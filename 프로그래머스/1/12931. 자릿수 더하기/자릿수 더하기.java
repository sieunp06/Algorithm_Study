public class Solution {
    public int solution(int n) {
        int answer = 0;

        for (char number: String.valueOf(n).toCharArray()) {
            answer += number - '0';
        }

        return answer;
    }
}