class Twitter {
    private ArrayList<int[]> list = new ArrayList<>();
    private HashMap<Integer, HashSet<Integer>> following = new HashMap<>();
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        list.add(new int[]{userId, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        HashSet<Integer> follow = following.get(userId);
        List<Integer> answer = new ArrayList<>();
        for(int i = list.size()-1; i >= 0; --i) {
            if(list.get(i)[0] == userId || (follow != null && follow.contains(list.get(i)[0]))) {
                answer.add(list.get(i)[1]);
                if(answer.size() == 10) return answer;
            }
        }
        return answer;
    }
    
    public void follow(int followerId, int followeeId)  {       HashSet<Integer> id = following.get(followerId);
        if(id == null) {
            HashSet<Integer> list = new HashSet<>();
            list.add(followeeId);
            following.put(followerId, list);
        } else {
            id.add(followeeId);
        }
        
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> id = following.get(followerId);
        id.remove(Integer.valueOf(followeeId));
    }
}
