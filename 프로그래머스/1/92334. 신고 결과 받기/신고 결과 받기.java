import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> solution(String[] id_list, String[] report, int k) {        
        Set<String> set = new HashSet<>();
        Map<String, List<String>> reported = new HashMap<>();
        Map<String, Integer> mail = new HashMap<>();
        
        for (String rep : report) {
            set.add(rep);
        }
        
        for (String rep : set) {
            StringTokenizer st = new StringTokenizer(rep);
            String reportPerson = st.nextToken();
            String reportedPerson = st.nextToken();
            
            if (reported.containsKey(reportedPerson)) {
                List<String> list = reported.get(reportedPerson);
                list.add(reportPerson);
                reported.put(reportedPerson, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(reportPerson);
                reported.put(reportedPerson, list);
            }
        }
        
        for (String key : reported.keySet()) {
            if (reported.get(key).size() >= k) {
                for (String name : reported.get(key)) {
                    mail.put(name, mail.getOrDefault(name, 0) + 1);
                }
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        for (String id : id_list) {
            if (!mail.containsKey(id)) {
                answer.add(0);
            } else {
                answer.add(mail.get(id));
            }
        }
        
        return answer;
    }
}