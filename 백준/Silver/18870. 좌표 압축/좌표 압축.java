import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N;
    static int[] numbers;
    static int[] sortedNumbers;
    static Map<Integer, Integer> compressedMap;

    public static void main(String[] args) throws IOException {
        init();
        compressCoordinates();
        printCompressedCoordinates();
        System.out.println(stringBuilder);
    }

    static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[N];
        sortedNumbers = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
            sortedNumbers[i] = numbers[i];
        }
    }

    static void compressCoordinates() {
        Arrays.sort(sortedNumbers);
        compressedMap = new HashMap<>();

        int rank = 0;
        for (int num : sortedNumbers) {
            if (!compressedMap.containsKey(num)) {
                compressedMap.put(num, rank++);
            }
        }
    }

    static void printCompressedCoordinates() {
        for (int num : numbers) {
            stringBuilder.append(compressedMap.get(num)).append(" ");
        }
    }
}
