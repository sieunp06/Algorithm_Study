import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] nums = new int[N];
        int[] count = new int[8001];
        int sum = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            nums[i] = num;
            sum += num;
            count[num + 4000]++;

            if (num < min) min = num;
            if (num > max) max = num;
        }

        Arrays.sort(nums);

        stringBuilder.append(Math.round((double) sum / N)).append("\n");
        stringBuilder.append(nums[N / 2]).append("\n");
        int modeMax = 0;
        for (int i = 0; i < 8001; i++) {
            if (count[i] > modeMax) {
                modeMax = count[i];
            }
        }

        List<Integer> modeList = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (count[i] == modeMax) {
                modeList.add(i - 4000);
            }
        }

        if (modeList.size() == 1) {
            stringBuilder.append(modeList.get(0)).append("\n");
        } else {
            Collections.sort(modeList);
            stringBuilder.append(modeList.get(1)).append("\n");
        }

        stringBuilder.append(max - min).append("\n");

        System.out.print(stringBuilder);
    }
}
