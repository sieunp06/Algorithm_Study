import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import java.time.LocalTime;
import java.time.Duration;

class Solution {
    public List<Integer> solution(int[] fees, String[] records) {
        Map<Integer, LocalTime> inCar = new HashMap<>();
        Map<Integer, Integer> totalMin = new HashMap<>();
        StringTokenizer st;
        
        for (String record: records) {
            st = new StringTokenizer(record);
            
            LocalTime time = LocalTime.parse(st.nextToken());
            int carNum = Integer.parseInt(st.nextToken());
            String status = st.nextToken();
            
            if (status.equals("IN")) {
                inCar.put(carNum, time);
            } else {
                LocalTime inTime = inCar.get(carNum);
                inCar.remove(carNum);
                
                Duration parking = Duration.between(inTime, time);
                int parkingMin = (int)parking.toMinutes();
                
                totalMin.put(carNum, totalMin.getOrDefault(carNum, 0) + parkingMin);
            }
        }
        
        if (!inCar.isEmpty()) {
            LocalTime outTime = LocalTime.of(23,59);
            
            for (int remainCarNum : inCar.keySet()) {
                int remainCarParkingMin = (int)Duration.between(inCar.get(remainCarNum), outTime).toMinutes();
                totalMin.put(remainCarNum, totalMin.getOrDefault(remainCarNum, 0) + remainCarParkingMin);
            }
        }
        
        List<Integer> keySet = new ArrayList<>(totalMin.keySet());
        Collections.sort(keySet);
        
        List<Integer> answer = new ArrayList<>();
        
        for (int sortedCarNum: keySet) {
            double min = totalMin.get(sortedCarNum);
            int answerPrice = fees[1];
            
            if (min - fees[0] > 0) {
                answerPrice += (int) Math.ceil((min - fees[0]) / fees[2]) * fees[3];
            } 
            
            answer.add(answerPrice);
        }
        
        return answer;
    }
}