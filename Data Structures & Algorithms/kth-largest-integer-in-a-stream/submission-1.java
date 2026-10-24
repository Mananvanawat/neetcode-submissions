class KthLargest {

    PriorityQueue<Integer> my = new PriorityQueue<>();
    int kG;
    int lengthOfArray;
    public KthLargest(int k, int[] nums) {
        kG = k;
        lengthOfArray = nums.length;
        for(int x : nums) {
            if(my.size() >= k) {
                my.offer(x);
                my.poll();
            } else {
                my.offer(x);
            }
        }
    }
    
    public int add(int x) {
        if(my.size() >= kG) {
                my.offer(x);
                my.poll();
            } else {
                my.offer(x);
        }
        return my.peek();
    }
}
