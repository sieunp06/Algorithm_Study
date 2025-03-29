import java.io.*;
import java.util.*;

public class Solution {
    static int N, answer;
    static int[][] map;
    static List<Person> people;
    static List<Stair> stairs;
    static int[] assignment;

    static class Person {
        int r, c;
        Person(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Stair {
        int r, c, length;
        Stair(int r, int c, int length) {
            this.r = r;
            this.c = c;
            this.length = length;
        }

    }

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 1; i <= T; i++) {
            init();
            dfs(0);
            stringBuilder.append("#").append(i).append(" ").append(answer - 1).append("\n");
        }
        System.out.println(stringBuilder);
    }

    static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];
        people = new ArrayList<>();
        stairs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (map[i][j] == 1) people.add(new Person(i, j));
                else if (map[i][j] >= 2) stairs.add(new Stair(i, j, map[i][j]));
            }
        }

        assignment = new int[people.size()];
        answer = Integer.MAX_VALUE;
    }

    static void dfs(int idx) {
        if (idx == people.size()) {
            answer = Math.min(answer, simulate());
            return;
        }
        for (int i = 0; i < 2; i++) {
            assignment[idx] = i;
            dfs(idx + 1);
        }
    }

    static int simulate() {
        List<Integer>[] arrivalTimes = new List[2];
        for (int i = 0; i < 2; i++) arrivalTimes[i] = new ArrayList<>();

        for (int i = 0; i < people.size(); i++) {
            Person p = people.get(i);
            Stair s = stairs.get(assignment[i]);
            int dist = Math.abs(p.r - s.r) + Math.abs(p.c - s.c);
            arrivalTimes[assignment[i]].add(dist);
        }

        int totalTime = 0;
        for (int i = 0; i < 2; i++) {
            totalTime = Math.max(totalTime, getTime(arrivalTimes[i], stairs.get(i).length));
        }
        return totalTime;
    }

    static int getTime(List<Integer> arrivals, int stairLength) {
        Collections.sort(arrivals);

        List<Integer> startTime = new ArrayList<>();
        for (int arrival : arrivals) startTime.add(arrival + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int t : startTime) pq.offer(t);

        List<Integer> ongoing = new ArrayList<>();

        int curTime = 0;
        while (!pq.isEmpty() || !ongoing.isEmpty()) {
            while (!ongoing.isEmpty() && ongoing.get(0) == curTime) {
                ongoing.remove(0);
            }
            while (!pq.isEmpty() && pq.peek() <= curTime && ongoing.size() < 3) {
                pq.poll();
                ongoing.add(curTime + stairLength);
            }
            Collections.sort(ongoing);
            curTime++;
        }

        return curTime;
    }
}
