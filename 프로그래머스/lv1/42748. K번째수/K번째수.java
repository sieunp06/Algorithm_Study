import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < commands.length; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            int first = commands[i][0];
            int second = commands[i][1];
            int target = commands[i][2];
            
            for (int j = first - 1; j < second; j++) {
                arr.add(array[j]);
            }
            
            Collections.sort(arr);
            
            answer.add(arr.get(target - 1));
        }
        return answer;
    }
}