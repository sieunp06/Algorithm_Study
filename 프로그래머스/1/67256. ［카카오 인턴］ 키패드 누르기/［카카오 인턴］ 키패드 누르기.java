import java.util.List;
import java.util.ArrayList;

class Solution {
    StringBuilder answer = new StringBuilder();
    final List<Integer> LEFT = List.of(1, 4, 7);
    final List<Integer> RIGHT = List.of(3, 6, 9);
    int[] lefthand = {3, 0};
    int[] righthand = {3, 2};
    
    public String solution(int[] numbers, String hand) {        
        for (int number : numbers) {
            if (LEFT.contains(number)) {
                answer.append("L");
                lefthand[0] = number / 3;
                lefthand[1] = 0;
                continue;
            }
            if (RIGHT.contains(number)) {
                answer.append("R");
                righthand[0] = number / 3 - 1;
                righthand[1] = 2;
                continue;
            }
            calDistance(number, hand);
        }
        return answer.toString();
    }
    
    private void calDistance(int num, String hand) {
        int[] target = {num / 3, 1};
        if (num == 0) {
            target[0] = 3;
        }
        int leftDistance = Math.abs(target[0] - lefthand[0]) + Math.abs(target[1] - lefthand[1]);
        int rightDistance = Math.abs(target[0] - righthand[0]) + Math.abs(target[1] - righthand[1]);
        
        if (leftDistance < rightDistance) {
            lefthand[0] = num / 3;
            if (num == 0) {
                lefthand[0] = 3;
            }
            lefthand[1] = 1;
            answer.append("L");
        } else if (leftDistance > rightDistance) {
            righthand[0] = num / 3;
            if (num == 0) {
                righthand[0] = 3;
            }
            righthand[1] = 1;
            answer.append("R");
        } else {
            if (hand.equals("right")) {
                righthand[0] = num / 3;
                if (num == 0) {
                    righthand[0] = 3;
                }
                righthand[1] = 1;
                answer.append("R");
            } else {
                lefthand[0] = num / 3;
                if (num == 0) {
                    lefthand[0] = 3;
                }
                lefthand[1] = 1;
                answer.append("L");
            }
        }
    }
}