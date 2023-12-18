import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> message = new ArrayList<>();
        List<String> stat = new ArrayList<>();
        
        for (String record_check : record) {
            StringTokenizer st = new StringTokenizer(record_check);
            String status = st.nextToken(); // Enter, Leave, Change
            String id = st.nextToken();
            
            if (status.equals("Leave")) {
                message.add(id);
                stat.add("Leave");
            } else {
                String nick = st.nextToken();
                map.put(id, nick);
                if (status.equals("Enter")) {
                    message.add(id);
                    stat.add("Enter");
                }
            }
        }
        
        String[] answer = new String[message.size()];
        
        for (int i = 0; i < answer.length; i++) {
            String result = map.get(message.get(i));
            if (stat.get(i).equals("Leave")) {
                result += "님이 나갔습니다.";
            } else {
                result += "님이 들어왔습니다.";
            }
            answer[i] = result;
        }
        
        return answer;
    }
}