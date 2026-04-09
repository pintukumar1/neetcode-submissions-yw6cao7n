class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        for(int i=0; i<n; i++) {
            int[] current = intervals[i];

            if(current[1] < newInterval[0]) {
                result.add(current);
            } else if(newInterval[1] < current[0]) {
                result.add(newInterval);
                result.add(current);
                for(int j=i+1; j<n; j++) {
                    result.add(intervals[j]);
                }
                return result.toArray(new int[result.size()][]);

            } else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }
        result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }
}
