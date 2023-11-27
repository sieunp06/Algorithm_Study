import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        
        for (int num : lost) {
            if (num == -1) {
                continue;
            } 
            for (int i = 0; i < reserve.length; i++) {
                if (num - 1 == reserve[i] || num + 1 == reserve[i]) {
                    answer++;
                    reserve[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}