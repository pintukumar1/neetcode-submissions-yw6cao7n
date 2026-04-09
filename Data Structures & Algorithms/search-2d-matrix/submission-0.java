class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int total = rows * columns;

        int left = 0;
        int right = total - 1;

        while(left <= right) {
            int mid = left + (right - left)/2;
            int cRow = mid/columns;
            int cColumn = mid%columns;

            if(matrix[cRow][cColumn] == target) {
                return true;
            } else if(matrix[cRow][cColumn] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
