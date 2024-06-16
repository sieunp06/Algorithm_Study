import java.util.Arrays;
import java.util.stream.*;

class Solution {
    public int solution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }
}