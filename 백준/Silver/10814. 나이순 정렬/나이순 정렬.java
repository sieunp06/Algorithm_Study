import java.io.*;
import java.util.*;
import java.util.stream.Collector;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static class Person {
        int idx;
        int age;
        String name;
        Person(int idx, int age, String name) {
            this.idx = idx;
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        List<Person> persons = new ArrayList<>();

        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            persons.add(new Person(i, Integer.parseInt(stringTokenizer.nextToken()), stringTokenizer.nextToken()));
        }

        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.age == o2.age) {
                    return o1.idx - o2.idx;
                }
                return o1.age - o2.age;
            }
        });

        for (Person person : persons) {
            System.out.println(person.age + " " + person.name);
        }
    }
}
