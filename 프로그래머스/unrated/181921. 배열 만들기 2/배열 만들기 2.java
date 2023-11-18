import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            String text = String.valueOf(i);
            boolean flag = true;
            for (char num : text.toCharArray()) {
                if (!(num == '5' || num == '0')) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer.add(i);
            }
        }
        if (answer.isEmpty()) {
            answer.add(-1);
        }
        return answer;
    }
}