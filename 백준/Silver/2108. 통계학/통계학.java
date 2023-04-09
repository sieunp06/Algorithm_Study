import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine());
        int[] numbers = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> mostUsedKeys = new ArrayList<>();      
        
        int total = 0;
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            numbers[i] = num;
            total += num;
        }
        
        Arrays.sort(numbers);
        
        for (int x : numbers)
        	map.put(x, map.getOrDefault(x, 0) + 1);
        Integer maxValue = Collections.max(map.values());
        
        for (int key : map.keySet()) {
            if (map.get(key).equals(maxValue))
                mostUsedKeys.add(key);
        }
        mostUsedKeys.sort(Comparator.naturalOrder());
        
        // 산술 평균
        System.out.println((int)Math.round((double)total / N));
        // 중앙값
        System.out.println(numbers[N / 2]);
        // 최빈값
        if (mostUsedKeys.size() == 1)
            System.out.println(mostUsedKeys.get(0));
        else
        	System.out.println(mostUsedKeys.get(1));
        // 범위
        System.out.println(numbers[N - 1] - numbers[0]);
    }
} 