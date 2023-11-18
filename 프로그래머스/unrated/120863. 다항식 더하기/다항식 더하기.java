import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String polynomial) {
        String answer = "";
        
        String[] arr = polynomial.split("[+]");
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            String number = arr[i].trim().replaceAll("[^0-9]", "");
            if (number.equals("")) {
                number += "1";
            }
            int num = Integer.parseInt(number);
            if (arr[i].contains("x")) {
                map.put("x", map.getOrDefault("x", 0) + num);
            } else {
                map.put("num", map.getOrDefault("num", 0) + num);
            }
        }
        
        if (map.size() == 2) {
            if (map.get("x") == 1) {
                answer += "x + " + map.get("num");
            } else {
                answer += map.get("x") + "x + " + map.get("num");   
            }
        } else if (map.containsKey("x")) {
            if (map.get("x") == 1) {
                answer += "x";
            } else {
                answer += map.get("x") + "x";   
            }
        } else {
            answer += map.get("num");
        }
        
        return answer;
    }
}