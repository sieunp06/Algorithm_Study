import java.util.List;
import java.util.ArrayList;

class Solution {
    final int THE_NUMBER_OF_STUDENT = 3;
    public int[] solution(int[] answers) {
        List<Integer> answerList = new ArrayList<>();

        int[][] students = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int[] score = new int[THE_NUMBER_OF_STUDENT];
        
        int index = 0;
        for (int answerNum: answers) {            
            for (int i = 0; i < students.length; i++) {
                if (answerNum == students[i][index % students[i].length]) {
                    score[i]++;
                }
            }
            index++;
        }
        
        int max = 0;
        for (int i = 0; i < score.length; i++) {
            if (score[i] > max) {
                max = score[i];
            }
        }
        
        for (int i = 0; i < score.length; i++) {
            if (score[i] == max) {
                answerList.add(i);
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i) + 1;
        }
        
        return answer;
    }
}