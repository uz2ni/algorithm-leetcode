class Solution {
    // 가장 늦게까지 걸린 노드의 시간 반환
    public int networkDelayTime(int[][] times, int n, int k) {
        // 인접리스트화
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0; i<times.length; i++) {
            list.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }

        int[] dist = new int[n+1]; // 각 노드까지 걸린 최단 시간
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; // 출발노드는 무조건 0

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(new int[]{k, 0});
        
        boolean[] visited = new boolean[n+1];

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];

            if(visited[node]) continue;
            visited[node] = true;

            for(int[] next : list.get(node)) {
                int nxt = next[0], w = next[1];
                if(!visited[nxt] && dist[node]+w < dist[nxt]) {
                    dist[nxt] = dist[node]+w;
                    pq.offer(new int[]{nxt, dist[nxt]});
                }
            }
        }

        int maxTime = 0;
        for(int i=1; i<=n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}