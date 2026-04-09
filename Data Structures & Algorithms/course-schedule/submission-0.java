class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for(int[] prerequisite: prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            list.get(pre).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;

        while(!queue.isEmpty()) {
            count++;
            int deleted = queue.poll();
            List<Integer> courses = list.get(deleted);
            for(Integer course: courses) {
                indegree[course]--;
                if(indegree[course] == 0) {
                    queue.add(course);
                }
            }
        }

        return count == numCourses;

    }
}
