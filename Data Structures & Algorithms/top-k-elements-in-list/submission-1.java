class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      for(int i=0; i<nums.length; i++) {
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
      }

      PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
      for(int num: map.keySet()) {
        pq.offer(num);
      }

      int deleted = 0;
      while(pq.size() > k) {
        pq.poll();
        deleted++;
      }

      int[] result = new int[k];
      for(int i=k-1; i>=0; i--) {
        int item = pq.poll();
        result[i] = item;
      }

      return result;
    }
}
