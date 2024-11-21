import java.util.*;

public class Solution {
    public int solution(int n) {
        int use = 0;
        while (n > 1) {
            if (n % 2 != 0) {
                n -= 1;
                use++;
            }
            n /= 2;
        }
        return use + 1;
    }
}