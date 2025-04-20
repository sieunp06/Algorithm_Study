import java.io.*;
import java.util.*;

public class Solution {
    static int[] dr = {0, -1, 1, 0, 0}; // 상, 하, 좌, 우 (1~4)
    static int[] dc = {0, 0, 0, -1, 1};

    static int N, M, K;
    static List<Microbe> microbes;
    static class Microbe {
        int r, c, count, dir;
        Microbe(int r, int c, int count, int dir) {
            this.r = r;
            this.c = c;
            this.count = count;
            this.dir = dir;
        }
    }

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            simulate();
            int result = getTotalMicrobes();
            stringBuilder.append("#").append(testCase).append(" ").append(result).append("\n");
        }

        System.out.print(stringBuilder);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        microbes = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int r = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            int count = Integer.parseInt(stringTokenizer.nextToken());
            int dir = Integer.parseInt(stringTokenizer.nextToken());

            microbes.add(new Microbe(r, c, count, dir));
        }
    }

    static void simulate() {
        for (int time = 0; time < M; time++) {
            Map<String, List<Microbe>> map = new HashMap<>();

            for (Microbe m : microbes) {
                int nr = m.r + dr[m.dir];
                int nc = m.c + dc[m.dir];

                if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
                    m.count /= 2;
                    m.dir = reverseDir(m.dir);
                }

                m.r = nr;
                m.c = nc;

                String key = nr + "," + nc;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(m);
            }

            List<Microbe> next = new ArrayList<>();

            for (List<Microbe> list : map.values()) {
                if (list.size() == 1) {
                    if (list.get(0).count > 0)
                        next.add(list.get(0));
                } else {
                    int sum = 0;
                    int max = 0;
                    int dir = 0;
                    for (Microbe m : list) {
                        sum += m.count;
                        if (m.count > max) {
                            max = m.count;
                            dir = m.dir;
                        }
                    }
                    Microbe merged = new Microbe(list.get(0).r, list.get(0).c, sum, dir);
                    next.add(merged);
                }
            }

            microbes = next;
        }
    }

    static int reverseDir(int dir) {
        if (dir == 1) return 2;
        if (dir == 2) return 1;
        if (dir == 3) return 4;
        return 3;
    }

    static int getTotalMicrobes() {
        int total = 0;
        for (Microbe m : microbes) {
            total += m.count;
        }
        return total;
    }
}
