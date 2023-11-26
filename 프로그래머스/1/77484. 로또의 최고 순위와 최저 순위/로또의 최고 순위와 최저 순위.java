import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();
        
        for (int win_num : win_nums) {
            list.add(win_num);
        }
        
        for (int lotto : lottos) {
            if (list.contains(lotto)) {
                answer[1]++;
            }
            if (lotto == 0) {
                answer[0]++;
            }
        }
        
        if (answer[1] == 6) {
            answer[0] = 6;
        } else {
            answer[0] += answer[1];
        }
        
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == 6) {
                answer[i] = 1;
            } else if (answer[i] == 5) {
                answer[i] = 2;
            } else if (answer[i] == 4) {
                answer[i] = 3;
            } else if (answer[i] == 3) {
                answer[i] = 4;
            } else if (answer[i] == 2) {
                answer[i] = 5;
            } else {
                answer[i] = 6;
            }
        }
        
        return answer;
    }
}