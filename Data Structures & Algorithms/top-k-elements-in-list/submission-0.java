class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      for(int num: nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }

      PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

      for(int num: map.keySet()) {
        pq.offer(num);
      }

      while(pq.size() > k) {
        pq.poll();
      }

      int[] result = new int[k];

      for(int i=k-1; i>=0; i--) {
        int deleted = pq.poll();
        result[i] = deleted;
      }
      return result;
    }
}
