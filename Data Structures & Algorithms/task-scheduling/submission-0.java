class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(char task : tasks) {
            freq[task - 'A']++;
        }

        for(int f : freq) {
            if(f > 0) maxHeap.offer(f);
        }
        int t = 0;
        Queue<int[]> coolDownQueue = new LinkedList<>();
        while(!maxHeap.isEmpty() || !coolDownQueue.isEmpty()) {
            t++;
            int count = 0;
            if(!maxHeap.isEmpty()) {
            count = maxHeap.poll();
            count--;
            }
            if(count > 0) coolDownQueue.offer(new int[] {count, t + n});

                if(!coolDownQueue.isEmpty() && t == coolDownQueue.peek()[1]) {
                    maxHeap.offer(coolDownQueue.poll()[0]);
                }

        }
        return t;
    }
}
