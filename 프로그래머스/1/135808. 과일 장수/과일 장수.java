import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : score) {
            list.add(num);
        }
        
        Collections.sort(list, Collections.reverseOrder());
        for (int i = m - 1; i < score.length; i += m) {
            answer += list.get(i) * m;
        }
        return answer;
    }
}