class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 인접리스트화
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++) {
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];
            list.get(from).add(to);
        }

        // dfs 사이클 찾기
        int[] visited = new int[numCourses]; // 0:미방문, 1:방문중, 2:방문완료
        for(int i=0; i<numCourses; i++) {
            if(visited[i] == 0) {
                if(dfs(list, i, visited)) {
                    return false; // 사이클 존재
                }
            }
        }

        return true;
    }

    public boolean dfs(List<List<Integer>> list, int node, int[] visited) {
        if(visited[node] == 1) {
            return true; // 탐색중 노드 재방문인 경우 사이클임
        }
        if(visited[node] == 2) {
            return false; // 이미 방문한 노드이면 패스
        }

        visited[node] = 1;

        for(int n : list.get(node)) {
            if(dfs(list, n, visited)) {
                return true;
            }
        }

        visited[node] = 2;
        return false;
    }
}