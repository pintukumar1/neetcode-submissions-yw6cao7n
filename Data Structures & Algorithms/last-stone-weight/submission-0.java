class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<stones.length; i++) {
            pq.add(stones[i]);
        }


        while(pq.size() > 1) {
            int polled1 = pq.poll();
            int polled2 = pq.poll();

            int difference = Math.abs(polled1 - polled2);
            pq.add(difference);
        }

        return pq.peek();
    }
}
