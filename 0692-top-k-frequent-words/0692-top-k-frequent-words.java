class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> mp=new HashMap<>();
        for(int i=0;i<words.length;i++){
            mp.put(words[i],mp.getOrDefault(words[i],0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> {
            if(mp.get(a) != mp.get(b)){
                return mp.get(b) - mp.get(a);
            }
            return a.compareTo(b);
        });
        pq.addAll(mp.keySet());
        int count=0;
        List<String> ans=new ArrayList<>();
        while(!pq.isEmpty()){
            if(count==k)break;
            String s=pq.poll();
            ans.add(s);
            count++;
        }
        return ans;
    }
}