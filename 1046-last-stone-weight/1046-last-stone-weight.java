
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int n : stones) {
            pq.offer(n);
        }

        while (pq.size() > 1) {
            int largest = pq.poll();
            int secondLargest = pq.poll();

            if (largest != secondLargest) {
                pq.offer(largest - secondLargest);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
