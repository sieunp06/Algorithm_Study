import java.util.Arrays;

class Solution {
    public long solution(long n) {
        char[] alpha = String.valueOf(n).toCharArray();
        Arrays.sort(alpha);
        String answer = "";
        for (int i = alpha.length - 1; i >= 0; i--) {
            answer += alpha[i];
        }
        return Long.parseLong(answer);
    }
}