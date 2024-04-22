import java.util.stream.*;

public class Solution {
    public int solution(int n) {
        return String.valueOf(n).chars()
            .map(number -> number - '0')
            .sum();
    }
}