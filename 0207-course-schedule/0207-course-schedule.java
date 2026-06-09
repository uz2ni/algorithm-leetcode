class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 인접 리스트로 변경
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
                adjList.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites) {
            adjList.get(pre[0]).add(pre[1]); // 선수과목들을 담아서 역방향으로 탐색
        }
        
        int[] visited = new int[numCourses]; // 0:미방문 1:방문중 2:방문완료
        for(int i=0; i<numCourses; i++) {
            if(visited[i] == 0) {
                if(hasCycle(i, adjList, visited)) {
                    return false; // 사이클 발견 시 return
                }
            }
        }
        return true;
    }
    public boolean hasCycle(int i, List<List<Integer>> adjList, int[] visited) {
        // basecase
        if(visited[i] == 1) return true; // 방문중 노드 다시 만난거라 사이클 존재
        if(visited[i] == 2) return false; // 이미 안전한 노드라 사이클없이 끝냄

        visited[i] = 1;
        // recursive
        for (int neighbor : adjList.get(i)) {
            if(hasCycle(neighbor, adjList, visited)) {
                return true;
            }
        }
        visited[i] = 2;
        return false;
    }
}
