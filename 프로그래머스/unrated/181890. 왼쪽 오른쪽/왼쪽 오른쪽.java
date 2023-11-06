import java.util.ArrayList;

class Solution {
    public ArrayList<String> solution(String[] str_list) {
        ArrayList<String> answer = new ArrayList<>();
        
        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l")) {
                return answer;
            } else if (str_list[i].equals("r")) {
                answer.clear();
                for (int j = i + 1; j < str_list.length; j++) {
                    answer.add(str_list[j]);
                }
                return answer;
            } else {
                answer.add(str_list[i]);
            }
        }
        
        answer.clear();
        
        return answer;
    }
}