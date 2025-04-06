import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, K, A, B;
    static int[] receptionTimes;
    static int[] repairTimes;
    
    static Customer[] customers;
    static int[][] receptionDesks;
    static int[][] repairDesks;
    
    static Queue<Customer> receptionWaiting;
    static Queue<Customer> repairWaiting;

    static class Customer {
        int id;
        int arrivalTime;
        int receptionDeskNum;
        int repairDeskNum;

        public Customer(int id, int arrivalTime) {
            this.id = id;
            this.arrivalTime = arrivalTime;
            this.receptionDeskNum = 0;
            this.repairDeskNum = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim()); 

        for (int tc = 1; tc <= T; tc++) {
            init(br);
            int result = solve();
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }
    
    static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 접수 창구 개수
        M = Integer.parseInt(st.nextToken()); // 수리 창구 개수
        K = Integer.parseInt(st.nextToken()); // 고객 수
        A = Integer.parseInt(st.nextToken()); // 찾는 접수 창구 번호
        B = Integer.parseInt(st.nextToken()); // 찾는 수리 창구 번호

        receptionTimes = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            receptionTimes[i] = Integer.parseInt(st.nextToken());
        }

        repairTimes = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            repairTimes[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        customers = new Customer[K + 1];
        for (int i = 1; i <= K; i++) {
            int arrivalTime = Integer.parseInt(st.nextToken());
            customers[i] = new Customer(i, arrivalTime);
        }

        receptionDesks = new int[N + 1][2]; 
        repairDesks = new int[M + 1][2];

        // 대기열 초기화
        receptionWaiting = new LinkedList<>();
        repairWaiting = new LinkedList<>();
    }
    
    static int solve() {
        int currentTime = 0;
        int processedCustomers = 0;
        
        while (processedCustomers < K) {
            processArrivingCustomers(currentTime);
            processCompletedReception(currentTime);
            assignCustomersToReception(currentTime);
            processedCustomers += processCompletedRepair(currentTime);
            assignCustomersToRepair(currentTime);
            currentTime++;
        }
        return calculateResult();
    }

    static void processArrivingCustomers(int currentTime) {
        for (int i = 1; i <= K; i++) {
            if (customers[i].arrivalTime == currentTime) {
                receptionWaiting.offer(customers[i]);
            }
        }
    }

    static void processCompletedReception(int currentTime) {
        for (int i = 1; i <= N; i++) {
            if (receptionDesks[i][0] > 0 && receptionDesks[i][1] == currentTime) {
                int customerIdx = receptionDesks[i][0];
                customers[customerIdx].receptionDeskNum = i;
                repairWaiting.offer(customers[customerIdx]);
                receptionDesks[i][0] = 0; 
            }
        }
    }

    static void assignCustomersToReception(int currentTime) {
        for (int i = 1; i <= N; i++) {
            if (receptionDesks[i][0] == 0 && !receptionWaiting.isEmpty()) {
                Customer customer = receptionWaiting.poll();
                receptionDesks[i][0] = customer.id;
                receptionDesks[i][1] = currentTime + receptionTimes[i];
            }
        }
    }
    
    static int processCompletedRepair(int currentTime) {
        int count = 0;
        for (int i = 1; i <= M; i++) {
            if (repairDesks[i][0] > 0 && repairDesks[i][1] == currentTime) {
                count++; 
                repairDesks[i][0] = 0; 
            }
        }
        return count;
    }

    static void assignCustomersToRepair(int currentTime) {
        for (int i = 1; i <= M; i++) {
            if (repairDesks[i][0] == 0 && !repairWaiting.isEmpty()) {
                Customer customer = repairWaiting.poll();
                customer.repairDeskNum = i;
                repairDesks[i][0] = customer.id;
                repairDesks[i][1] = currentTime + repairTimes[i];
            }
        }
    }

    static int calculateResult() {
        int result = 0;
        for (int i = 1; i <= K; i++) {
            if (customers[i].receptionDeskNum == A && customers[i].repairDeskNum == B) {
                result += customers[i].id;
            }
        }

        return (result == 0) ? -1 : result;
    }
}