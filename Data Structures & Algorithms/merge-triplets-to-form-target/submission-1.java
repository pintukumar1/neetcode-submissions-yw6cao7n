class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        boolean foundX = false;
        boolean foundY = false;
        boolean foundZ = false;

        for(int i=0; i<triplets.length; i++) {
            if(triplets[i][0] > target[0] || 
               triplets[i][1] > target[1] || 
               triplets[i][2] > target[2]) {
                continue;
            }
            if(triplets[i][0] == target[0]) {
                foundX = true;
            } 
            if(triplets[i][1] == target[1]) {
                foundY = true;
            } 
            if(triplets[i][2] == target[2]) {
                foundZ = true;
            }
            
        }

        return foundX && foundY && foundZ;
    }
}
