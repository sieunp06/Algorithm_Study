import java.util.ArrayList;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] inputs = s.split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (String alpha : inputs) {
            if (alpha.equals("Z")) {
                answer -= arr.get(arr.size() - 1);
            } else {
                int num = Integer.parseInt(alpha);
                answer += num;
                arr.add(num);
            }
        }
        
        return answer;
    }
}