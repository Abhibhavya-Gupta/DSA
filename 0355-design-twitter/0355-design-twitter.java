class Post{
    int time;
    int tweetId;
    public Post(int time,int tweetId)
    {
        this.time=time;
        this.tweetId=tweetId;
    }
}

class Twitter {
    int time;
    HashMap<Integer,HashSet<Integer>> followMap;
    //userId ,Set<followeeId>

    HashMap<Integer,List<Post>> tweetMap;
    //userId ,list<(post>

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap=new HashMap<>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Post p = new Post(time,tweetId);
       
        if(tweetMap.containsKey(userId))
        {
            tweetMap.get(userId).add(p);
        }
        else{
            List<Post> l = new ArrayList<>();
            l.add(p);
            tweetMap.put(userId,l);
        }

        if(!followMap.containsKey(userId))
        {
            HashSet<Integer> set = new HashSet<>();
            set.add(userId);
            followMap.put(userId,set);
        }

         time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        //get the followee set of userId
        Set<Integer> followSet = followMap.getOrDefault(userId, new HashSet<>());
        List<Post> totalPosts = new ArrayList<>();
        //get all the posts
        for(int id:followSet)
        {
           List<Post> tempPosts = tweetMap.get(id);
           if(tempPosts!=null)
           totalPosts.addAll(tempPosts);
        }
        Collections.sort(totalPosts,(a,b)->b.time-a.time);

        //get first 10
        List<Integer> ans = new ArrayList<>();
        int i=0;
        while(i<10 && i<totalPosts.size())
        {
            ans.add(totalPosts.get(i).tweetId);
            i++;
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {

        if(!followMap.containsKey(followerId))
        {
            HashSet<Integer> set = new HashSet<>();
            set.add(followerId);
            set.add(followeeId);
            followMap.put(followerId,set);
        }
        else
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
         if (followMap.containsKey(followerId)) {
        followMap.get(followerId).remove(followeeId);
    }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */