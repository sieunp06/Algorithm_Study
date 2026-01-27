import java.io.*;
import java.util.*;

public class Main {
    private static class Line {
        long start, end;
        Line(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class Event implements Comparable<Event> {
        long x;
        int type;
        Event(long x, int type) {
            this.x = x;
            this.type = type;
        }

        @Override
        public int compareTo(Event o) {
            if (this.x == o.x) return o.type - this.type;
            return Long.compare(this.x, o.x);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(bufferedReader.readLine());
        Line[] lines = new Line[N];
        List<Long> coords = new ArrayList<>();
        List<Event> events = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            long start = Long.parseLong(stringTokenizer.nextToken());
            long end = Long.parseLong(stringTokenizer.nextToken());

            lines[i] = new Line(start, end);
            coords.add(start);
            coords.add(end);
        }

        Collections.sort(coords);
        List<Long> unique = new ArrayList<>();
        for (long x : coords) {
            if (unique.isEmpty() || unique.get(unique.size() - 1) != x)
                unique.add(x);
        }

        for (Line l : lines) {
            events.add(new Event(l.start, +1));
            events.add(new Event(l.end, -1));
        }

        Collections.sort(events);

        int cur = 0, max = 0;
        long bestPos = 0;

        for (Event e : events) {
            cur += e.type;
            if (cur > max) {
                max = cur;
                bestPos = e.x;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(max).append("\n");

        for (int i = 0; i < N; i++) {
            if (lines[i].start <= bestPos && bestPos <= lines[i].end) {
                stringBuilder.append(i + 1).append(" ");
            }
        }

        System.out.println(stringBuilder);
    }
}
