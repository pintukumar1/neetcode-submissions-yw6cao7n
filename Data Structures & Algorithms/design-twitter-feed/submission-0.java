class Twitter {
    int time = 0;
    Map<Integer, List<int[]>> tweets;
    Map<Integer, Set<Integer>> follows;

    public Twitter() {
        tweets = new HashMap<>();
        follows = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{tweetId, time++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        
        follows.putIfAbsent(userId, new HashSet<>());
        follows.get(userId).add(userId);

        for(int followee: follows.get(userId)) {
            if (tweets.containsKey(followee)) { 
                List<int[]> tweetList = tweets.get(followee);
                for(int i=tweetList.size() - 1; i>=0 && i>= tweetList.size() - 10; i--) {
                    maxHeap.offer(tweetList.get(i));
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!maxHeap.isEmpty() && result.size()<10) {
            result.add(maxHeap.poll()[0]);
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}
