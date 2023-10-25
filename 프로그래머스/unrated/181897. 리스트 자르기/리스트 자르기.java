import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int n, int[] slicer, int[] num_list) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        if (n == 1) {
            for (int i = 0; i <= slicer[1]; i++) {
                answer.add(num_list[i]);
            }
            return answer;
        }
        if (n == 2) {
            for (int i = slicer[0]; i < num_list.length; i++) {
                answer.add(num_list[i]);
            }
            return answer;
        }
        if (n == 3) {
            for (int i = slicer[0]; i <= slicer[1]; i++) {
                answer.add(num_list[i]);
            }
            return answer;
        }
        if (n == 4) {
            for (int i = slicer[0]; i <= slicer[1]; i += slicer[2]) {
                answer.add(num_list[i]);
            }
            return answer;
        }
        
        return answer;
    }
}