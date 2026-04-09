class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i=0; i <= heights.length; i++) {
            int currentHeight = heights.length == i ? 0 : heights[i];
            while(stack.size() > 0 && currentHeight < heights[stack.peek()]) {
                int popped = stack.pop();
                int leftBoundary = stack.size() == 0 ? -1 : stack.peek();
                int width = i - leftBoundary - 1;
                int height = heights[popped];
                int area = width * height;
                maxArea = Math.max(area, maxArea);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
