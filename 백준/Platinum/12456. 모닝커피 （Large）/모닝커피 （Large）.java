import java.io.*;
import java.util.*;

public class Main {
    static class Coffee {
        long c, t, s;
        Coffee(long c, long t, long s) {
            this.c = c;
            this.t = t;
            this.s = s;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            long K = Long.parseLong(stringTokenizer.nextToken());

            PriorityQueue<Coffee> datePQ =
                    new PriorityQueue<>((a, b) -> Long.compare(b.t, a.t));

            for (int i = 0; i < N; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                long c = Long.parseLong(stringTokenizer.nextToken());
                long t = Long.parseLong(stringTokenizer.nextToken());
                long s = Long.parseLong(stringTokenizer.nextToken());
                t = Math.min(t, K);
                datePQ.add(new Coffee(c, t, s));
            }

            PriorityQueue<Coffee> satPQ =
                    new PriorityQueue<>((a, b) -> Long.compare(b.s, a.s));

            long curDay = K;
            long answer = 0;

            while (!datePQ.isEmpty()) {
                Coffee cur = datePQ.poll();

                long canUseDays = curDay - cur.t;

                while (canUseDays > 0 && !satPQ.isEmpty()) {
                    Coffee best = satPQ.poll();
                    long use = Math.min(best.c, canUseDays);

                    answer += use * best.s;
                    best.c -= use;
                    canUseDays -= use;

                    if (best.c > 0) {
                        satPQ.add(best);
                    }
                }

                satPQ.add(cur);
                curDay = cur.t;
            }

            long remainingDays = curDay;
            while (remainingDays > 0 && !satPQ.isEmpty()) {
                Coffee best = satPQ.poll();
                long use = Math.min(best.c, remainingDays);

                answer += use * best.s;
                best.c -= use;
                remainingDays -= use;

                if (best.c > 0) {
                    satPQ.add(best);
                }
            }

            stringBuilder.append("Case #").append(tc).append(": ")
                    .append(answer).append('\n');
        }

        System.out.print(stringBuilder);
    }
}
