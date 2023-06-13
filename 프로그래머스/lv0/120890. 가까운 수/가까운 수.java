import java.util.Arrays;

class Solution {
    public int solution(int[] array, int n) {    
        Arrays.sort(array);
        
        int charge = Math.abs(n - array[0]);
        int idx = 0;
        
        for (int i = 1; i < array.length; i++) {
            if (charge > Math.abs(n - array[i])) {
                charge = Math.abs(n - array[i]);
                idx = i;
            }
        }
        
        return array[idx];
    }
}