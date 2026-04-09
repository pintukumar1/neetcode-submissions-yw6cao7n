class CountSquares {
    Map<Integer, Map<Integer, Integer>> points;

    public CountSquares() {
        points = new HashMap<>();    
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        if(!points.containsKey(x)) {
            points.put(x, new HashMap<>());
        }

        Map<Integer, Integer> yMap = points.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }
    
    public int count(int[] point) {
        int x = point[0], y=point[1];
        if(!points.containsKey(x)) {
            return 0;
        }
        int result = 0;
        Map<Integer, Integer> yMap = points.get(x);

        for(int y2: yMap.keySet()) {
            if (y2 == y) continue;
            int d = Math.abs(y2-y);

            int countY = yMap.get(y2);

            result += countY * points.getOrDefault(x+d, new HashMap<>()).getOrDefault(y, 0) 
                * points.getOrDefault(x+d, new HashMap<>()).getOrDefault(y2, 0);
            result += countY * points.getOrDefault(x-d, new HashMap<>()).getOrDefault(y, 0) 
                * points.getOrDefault(x-d, new HashMap<>()).getOrDefault(y2, 0);

        }
        return result;
    }
}
