class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        return bfs(startGene, endGene, bankSet, visited);
    }

    public int bfs(String startGene, String endGene, Set<String> bankSet, Set<String> visited) {

        char[] chs = {'A', 'C', 'G', 'T'};
        
        // Queue (현재문자열)
        // 레벨별로 진행해서 카운팅 세기
        Queue<String> q = new ArrayDeque<>();
        q.offer(startGene);
        visited.add(startGene);

        int cnt = 0;

        while(!q.isEmpty()) {

            int size = q.size();

            for(int i=0; i<size; i++) {
                String cur = q.poll();
                
                // endGene 체크
                if(cur.equals(endGene)) return cnt;

                // 문자 바꾸기
                for(int a=0; a<cur.length(); a++) {
                    char[] arr = cur.toCharArray();
                    for(int b=0; b<chs.length; b++) {
                        if(arr[a] != chs[b]) { // 현재 문자와 다른 경우만
                            // 변환한 문자열이 은행에 존재하면 큐에 삽입, visited 처리 
                            char temp = arr[a];
                            arr[a] = chs[b]; // 변환
                            String newStr = new String(arr);
                            arr[a] = temp; // 되돌리기

                            if(visited.contains(newStr) || !bankSet.contains(newStr)) continue;

                            q.offer(newStr);
                            visited.add(newStr);                            
                        }
                    }
                }

            }

            cnt++;
        }
        return -1;
    }
}