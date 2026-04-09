class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int write = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<nums.length; i++) {
            while(!dq.isEmpty() && dq.peekFirst() < i-k+1) {
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i>=k-1) {
                result[write++] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}
