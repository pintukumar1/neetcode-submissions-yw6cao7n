class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0; i<tasks.length; i++) {
            char ch = tasks[i];
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int val: map.values()) {
            pq.add(val);
        }

        int time = 0;

        while(!pq.isEmpty()) {
            int cycle = n+1;
            List<Integer> temp = new ArrayList<>();
            while(cycle > 0 && !pq.isEmpty()) {
                int round = pq.poll();
                if(round - 1 > 0) {
                    temp.add(round-1);
                }
                time++;
                cycle--;
            }

            for(int tempp: temp) {
                pq.add(tempp);
            }

           if(!pq.isEmpty()) {
                time += cycle;
            }
        }

        return time;
    }
}
