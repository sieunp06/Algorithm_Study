import java.util.ArrayList;

class Solution {
    public ArrayList<String> solution(String[] todo_list, boolean[] finished) {
        ArrayList<String> answer = new ArrayList<>();
        
        for (int i = 0; i < todo_list.length; i++) {
            if (!finished[i])
                answer.add(todo_list[i]);
        }
        return answer;
    }
}