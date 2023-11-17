class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        double[] scoreAvg = new double[score.length];
        
        for (int i = 0; i < score.length; i++) {
            scoreAvg[i] = (score[i][0] + score[i][1]) / 2.0;
        }
        
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score.length; j++) {
                if (scoreAvg[i] < scoreAvg[j]) {
                    answer[i]++;
                }
            }
            answer[i]++;
        }
        
        return answer;
    }
}