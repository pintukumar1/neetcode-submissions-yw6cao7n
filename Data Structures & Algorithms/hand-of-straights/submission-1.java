class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        for(int x: hand) {
            if(!map.containsKey(x) || map.get(x) == null) {
                continue;
            }

            for(int i=0; i<groupSize; i++) {
                int num = x + i;

                if(!map.containsKey(num) || map.get(num) == null) {
                    return false;
                }
                if(map.get(num) == 1) {
                    map.remove(num);
                } else {
                    map.put(num,map.get(num) - 1);
                }
            }
        }

        return true;
    }
}
