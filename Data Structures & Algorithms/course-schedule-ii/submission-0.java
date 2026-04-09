class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] prerequisite: prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];

            adjList.get(pre).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        System.out.println(queue.peek());

        int[] order = new int[numCourses];
        int index = 0;

        while(!queue.isEmpty()) {
            int deleted = queue.poll();
            order[index++] = deleted;

            List<Integer> courses = adjList.get(deleted);
            for(Integer course: courses) {
                indegree[course]--;
                if(indegree[course] == 0) {
                    queue.add(course);
                }
            }
        }
        if(index != numCourses) {
            return new int[0];
        }

        return order;

    }
}
