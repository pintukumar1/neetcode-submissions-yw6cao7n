class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Arrays.fill(result, 0);

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i < n; i++) {
            while(stack.size() > 0 && temperatures[i] > temperatures[stack.peek()]) {
                int popped = stack.pop();
                result[popped] = i-popped;
            }
            stack.push(i);
        }

        return result;
    }

}
