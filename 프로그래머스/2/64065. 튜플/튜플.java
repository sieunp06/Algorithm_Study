import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        String[] processes = s.substring(2, s.length() - 1).split("}");
        
        List<String> process = new ArrayList<>();
        
        for (int i = 0; i < processes.length; i++) {
            if (processes[i].charAt(0) == ',') {
                processes[i] = processes[i].substring(2, processes[i].length());
            }
            process.add(processes[i]);
        }
        
        Collections.sort(process, (String a, String b) -> a.length() - b.length());
        
        LinkedHashSet<Integer> lh = new LinkedHashSet<>();
        
        for (String p : process) {
            String[] nums = p.split(",");
            for (String num : nums) {
                lh.add(Integer.parseInt(num));
            }
        }
        
        for (int num : lh) {
            answer.add(num);
        }
        
        return answer;
    }
}