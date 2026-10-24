class MedianFinder {
    private PriorityQueue<Integer> min,max;
    private int size;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        min.offer(num);
        if(min.size() == max.size() || min.size() != max.size() && min.size() != 0 && max.size() != 0) {
            if(max.peek() > min.peek()) {
                int x = max.poll();
                int y = min.poll();
                min.offer(x);
                max.offer(y);
            }
        }

        if(min.size() - max.size() >=2) {
            Integer n = min.poll();
            max.offer(n);
        }
        
    }
    
    public double findMedian() {
        if(min.size() > max.size()) {
            return Double.valueOf(min.peek());
        } else {
            return (Double.valueOf(min.peek()) + Double.valueOf(max.peek()))/2;
        }
    }
}
