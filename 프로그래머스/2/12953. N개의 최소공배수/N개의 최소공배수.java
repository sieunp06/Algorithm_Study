import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        Arrays.sort(arr);
        int idx = 0;
        
        while (arr[idx] == 1) {
            idx++;
        }
        
        for (int i = idx; i < arr.length; i++) {
            for (int j = 2; j <= arr[i]; j++) {
                while (arr[i] % j == 0) {
                    arr[i] /= j;
                    answer *= j;
                    for (int k = i + 1; k < arr.length; k++) {
                        if (arr[k] % j == 0) {
                            arr[k] /= j;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}