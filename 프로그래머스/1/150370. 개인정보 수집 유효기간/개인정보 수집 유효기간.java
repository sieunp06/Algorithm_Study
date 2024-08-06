import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

import java.util.Arrays;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        StringTokenizer st;
        
        Map<String,Integer> map = new HashMap<>();
        List<Integer> trash = new ArrayList<>();
        
        for (String term : terms) {
            st = new StringTokenizer(term);
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        int idx = 1;
        for (String privacy : privacies) {
            st = new StringTokenizer(privacy);
            String date = st.nextToken();
            String term = st.nextToken();
            
            String[] expiredDate = date.split("[.]");
            int year = Integer.parseInt(expiredDate[0]);
            int month = Integer.parseInt(expiredDate[1]) + map.get(term); 
            int day = Integer.parseInt(expiredDate[2]) - 1;
            
            while (month > 12) {
                year++;
                month -= 12;
            }
            
            String[] todayDate = today.split("[.]");
            int today_year = Integer.parseInt(todayDate[0]);
            int today_month = Integer.parseInt(todayDate[1]);
            int today_day = Integer.parseInt(todayDate[2]);
            
            if (year < today_year) {
                trash.add(idx);
                idx++;
                continue;
            }
            if (year == today_year) {
                if (month < today_month) {
                    trash.add(idx);
                    idx++;
                    continue;
                } 
                if (month == today_month) {
                    if (day < today_day) {
                        trash.add(idx);
                        idx++;
                        continue;
                    }
                }
            }
            idx++;
        }
        
        return trash;
    }
}