import java.util.*;

class Solution {
    public String solution(String s) {
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(arr).min().getAsInt() + " " + Arrays.stream(arr).max().getAsInt();
    }
}