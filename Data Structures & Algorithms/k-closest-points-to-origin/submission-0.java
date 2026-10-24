class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] answer = new int[k][2];
        PriorityQueue<Point> closest = new PriorityQueue<>((t1, t2) ->   {     
            double z = Math.sqrt(t1.x*t1.x + t1.y*t1.y);
            double w = Math.sqrt(t2.x*t2.x + t2.y*t2.y);

            return Double.compare(z, w);
        });

        for(int[] point : points) {
            Point p = new Point(point[0], point[1]);
            closest.offer(p);
        }
        int i = 0;
        while(closest.size() > 0 && k > 0) {
            k = k - 1;
            Point p = closest.poll();
            answer[i] = new int[]{p.x, p.y};
            i = i + 1;
        }
        return answer;
    }
}
