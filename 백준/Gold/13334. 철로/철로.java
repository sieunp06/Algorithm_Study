import java.io.*;
import java.util.*;

public class Main {
    private static class Person implements Comparable<Person> {
        int start, end;
        Person(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Person o) {
            if (this.end == o.end) return this.start - o.start;
            return Integer.compare(this.end, o.end);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int home = Integer.parseInt(stringTokenizer.nextToken());
            int office = Integer.parseInt(stringTokenizer.nextToken());

            int start = Math.min(home, office);
            int end = Math.max(home, office);

            personList.add(new Person(start, end));
        }

        int d = Integer.parseInt(bufferedReader.readLine());

        Collections.sort(personList);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int answer = 0;

        for (Person person : personList) {
            int point = person.end - d;

            while (!priorityQueue.isEmpty() && priorityQueue.peek() < point) {
                priorityQueue.poll();
            }

            if (person.start >= point) {
                priorityQueue.add(person.start);
            }

            answer = Math.max(answer, priorityQueue.size());
        }

        System.out.println(answer);
    }
}
