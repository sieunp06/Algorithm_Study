import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> map = new HashMap<>();
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("enter"))
                map.put(name, status);
            if (status.equals("leave"))
                map.remove(name);
        }
        List<String> enterArr = new ArrayList<>(map.keySet());

        Collections.sort(enterArr, new Comparator<String>() {
            public int compare(String str, String str1) {
                return (str).compareTo(str1);
            }
        });

        Collections.reverse(enterArr);

        for (int i = 0; i < enterArr.size(); i++)
            System.out.println(enterArr.get(i));
    }
}