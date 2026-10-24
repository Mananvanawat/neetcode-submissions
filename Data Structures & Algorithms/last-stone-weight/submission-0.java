class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length < 2) {
            return stones[0];
        }
        PriorityQueue<Integer> stoneW = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : stones) {
            stoneW.offer(x);
        }
        
        while(stoneW.size() > 1) {
            int x = stoneW.poll(); 
            int y = stoneW.poll();
            
            if(x != y) {
                int z = Math.abs(x-y);
                stoneW.offer(z);
            }
        }

        if(stoneW.size() == 1) return stoneW.poll();
        return 0;
    }
}
