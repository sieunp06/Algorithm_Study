public class Solution {
    public int solution(int n) {
        int ans = 0;

        while (n > 1) {
            if (n % 2 != 0) {
                n -= 1;
                ans++;
            }
            n /= 2;
        }

        return ans + 1;
    }
}