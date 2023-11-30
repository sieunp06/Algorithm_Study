import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        
        String[] today_split = today.split("[.]");
        int today_year = Integer.parseInt(today_split[0]);
        int today_month = Integer.parseInt(today_split[1]);
        int today_day = Integer.parseInt(today_split[2]);
        
        for (String term : terms) {
            StringTokenizer st = new StringTokenizer(term);
            termMap.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            StringTokenizer st = new StringTokenizer(privacies[i]);
            
            String[] dates = st.nextToken().split("[.]");
            
            int year = Integer.parseInt(dates[0]);
            int month = Integer.parseInt(dates[1]) + termMap.get(st.nextToken());
            int day = Integer.parseInt(dates[2]) - 1;
            
            if (day < 1) {
                month--;
                day += 28;
            }
            while (month > 12) {
                year++;
                month -= 12;
            }
            
            if (year < today_year) {
                answer.add(i + 1);
                continue;
            } else if (year > today_year) {
                continue;
            }
            if (month < today_month) {
                answer.add(i + 1);
                continue;
            } else if (month > today_month) {
                continue;
            }
            if (day < today_day) {
                answer.add(i + 1);
            }
        }
        
        
        return answer;
    }
}