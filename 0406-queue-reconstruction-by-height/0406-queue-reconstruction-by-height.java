class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 정렬 (h 내림차순, k 오름차순)
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });

        // 리스트 k위치에 각 값 삽입
        List<int[]> queue = new LinkedList<>();
        for(int[] p : people) {
            queue.add(p[1], p);
        }

        return queue.toArray(new int[queue.size()][]);

/*
        // for 2번째~n-1 요소 체크
        // 내 앞 요소부터 앞으로 가면서, 해당하는 조건이면 그 곳에 둔다.
        for(int i=1; i<people.length; i++) {
            int h = people[i][0];
            int k = people[i][1];
            int idx = i-1; // 앞으로 나아가는 인덱스
            while(idx >= 0) {
                // h : i가 idx보다 크면 서로 교체
                if(h <= people[idx][0]) {
                    int temp = people[idx][0];
                    people[idx][0] = h;
                    people[i][0] = temp;
                    
                }
                // k : 앞 개수보다 
            }
        }
*/
        
    }
}