import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {        
        PriorityQueue<Job> requestedQueue = new PriorityQueue<>((j1, j2) -> j1.request - j2.request);
        PriorityQueue<Job> workingQueue = new PriorityQueue<>((j1, j2) -> j1.process - j2.process);
        
        for (int[] job: jobs) {
            int request = job[0];
            int process = job[1];
            
            requestedQueue.add(new Job(request, process));
        }
        
        int answer = 0;
        int time = 0;
        
        while (!requestedQueue.isEmpty() || !workingQueue.isEmpty()) {
            while (!requestedQueue.isEmpty() && requestedQueue.peek().request <= time) {
                Job willWorkingJob = requestedQueue.poll();
                workingQueue.add(willWorkingJob);
            }
            
            if (workingQueue.isEmpty()) {
                time = requestedQueue.peek().request;
                continue;
            }
            Job nowWorkingJob = workingQueue.poll();

            answer += time - nowWorkingJob.request + nowWorkingJob.process;
            time += nowWorkingJob.process;
        }
        
        return answer / jobs.length;
    }
}

class Job {
    int request;
    int process;
    
    Job(int request, int process) {
        this.request = request;
        this.process = process;
    }
}