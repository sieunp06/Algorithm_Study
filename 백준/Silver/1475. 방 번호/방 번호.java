import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();

        Map<Character, Integer> map = new HashMap<>();

        for (char num : input.toCharArray()) {
            if (num == '6') {
                map.put('9', map.getOrDefault('9', 0) + 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int max = 0;
        for (char key : map.keySet()) {
            int target;
            if (key == '6' || key == '9') {
                target = map.get('9') / 2;
                if (map.get('9') % 2 != 0) {
                    target++;
                }
            } else {
                target = map.get(key);
            }
            max = Math.max(max, target);
        }

        System.out.println(max);
    }
}
