class Solution {
    // 풀이 실패
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] p : prerequisites) {
            if(map.isEmpty()) {
                map.put(p[1],p[0]);
                continue;
            }
            if(map.containsKey(p[0])) {
                return false;
            }
            map.put(p[1],p[0]);
        }
        
        return true;
    }

    // 풀이1 : DFS 그래프 사이클 판별
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // graph 인접리스트
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        } 
        for(int i=0; i<prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] state = new int[numCourses]; // 0 미방문, 1 방문중, 2 완료

        // 모든 노드를 시작으로 순회하며 사이클 체크하는 이유 : 그래프 하나로 연결 아닐수도 있어서
        for(int i=0; i<numCourses; i++) { 
            if(state[i] == 0) {
                if(hasCycle(graph, state, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean hasCycle(List<List<Integer>> graph, int[] state, int node) {
        state[node] = 1; // 방문중 표시
        for(int nxt : graph.get(node)) {
            if(state[nxt] == 1) { // 방문중인 노드 또 만남 -> 사이클
                return true;
            }
            if(state[nxt] == 0 && hasCycle(graph, state, nxt)) { // 미방문이면 다음 노드부터 사이클 있는지 판별
                return true;
            }
        }

        state[node] = 2; // 노드 방문완료. 안전함 확정
        return false;
    }
}