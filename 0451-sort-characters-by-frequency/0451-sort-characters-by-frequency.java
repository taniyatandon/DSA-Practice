class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> mp=new HashMap<>();
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> mp.get(b) - mp.get(a));
        pq.addAll(mp.keySet());
        StringBuilder sb=new StringBuilder();

        while(!pq.isEmpty()){
            char ch=pq.poll();

            for(int i=0;i<mp.get(ch);i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}