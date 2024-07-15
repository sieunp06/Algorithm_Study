import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        List<Integer> win_nums_list = Arrays.stream(win_nums)
            .boxed()
            .collect(Collectors.toList());
        
        int numOfWin = Arrays.stream(lottos)
            .filter(num -> win_nums_list.contains(num))
            .boxed()
            .collect(Collectors.toList()).size();
        
        int numOfZero = Arrays.stream(lottos)
            .filter(num -> num == 0)
            .boxed()
            .collect(Collectors.toList()).size();
        
        answer[0] = giveAward(numOfWin + numOfZero);
        answer[1] = giveAward(numOfWin);
        return answer;
    }
    
    private int giveAward(int win) {
        if (win == 6) {
            return 1;
        }
        if (win == 5) {
            return 2;
        }
        if (win == 4) {
            return 3;
        }
        if (win == 3) {
            return 4;
        }
        if (win == 2) {
            return 5;
        }
        return 6;
    }
}