class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // 인접리스트화
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0; i<flights.length; i++) {
            list.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        List<int[]> subList = list.get(src);
        for(int i=0; i<subList.size(); i++) {
            int[] now = subList.get(i);
            pq.offer(new int[]{now[0],now[1],0});
        }

        // 추가: 노드별 "지금까지 처리한 최소 경유횟수" 기록
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            System.out.println("poll - " + cur[0] + " : " + cur[1] + ", " + cur[2]);
            if(cur[2] > k) continue;
            if(cur[0] == dst) return cur[1];
            
            // 추가: 이미 더 적거나 같은 경유횟수로 처리된 노드면 스킵
            if(cur[2] >= visited[cur[0]]) continue;
            visited[cur[0]] = cur[2];            

            // cur[0]이 가리키는 다음 위치 pq에 넣기
           subList = list.get(cur[0]);
           for(int i=0; i<subList.size(); i++) {
                int[] nxt = subList.get(i);
                int n1 = cur[1]+nxt[1];
                int n2 = cur[2]+1;
                pq.offer(new int[]{nxt[0],n1,n2});
                System.out.println("offer - " + nxt[0] + " : " + n1 + ", " + n2);
                System.out.println();
           }
        }
        
        return -1;
    }
}