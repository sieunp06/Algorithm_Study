import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        double total = 0;
        Map<String, Integer> map = new HashMap<>();
        while (true) {
            String name = bufferedReader.readLine();
            if (name == null) {
                break;
            }
            total++;
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        List<String> names = new ArrayList<>(map.keySet());
        Collections.sort(names);

        for (String name : names) {
            System.out.println(name + " " + String.format("%.4f", map.get(name) / total * 100));
        }
    }
}