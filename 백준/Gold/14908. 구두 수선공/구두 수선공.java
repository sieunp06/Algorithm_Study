import java.io.*;
import java.util.*;

public class Main {
    static class Job {
        int t, s, idx;
        Job(int t, int s, int idx) {
            this.t = t;
            this.s = s;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        List<Job> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int t = Integer.parseInt(stringTokenizer.nextToken());
            int s = Integer.parseInt(stringTokenizer.nextToken());
            list.add(new Job(t, s, i));
        }

        Collections.sort(list, (a, b) -> {
            long lhs = (long) a.t * b.s;
            long rhs = (long) b.t * a.s;
            return Long.compare(lhs, rhs);
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (Job j : list) {
            stringBuilder.append(j.idx).append(" ");
        }
        System.out.println(stringBuilder.toString().trim());
    }
}
