class Solution {
    // bottom-up
    public int climbStairs1(int n) {
        // 1칸 or 2칸씩 계단 올라갈 수 있음
        // 꼭대기까지 올라갈 수 있는 경우의 수
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int[] tb = new int[n+1];
        Arrays.fill(tb, -1);
        
        tb[1] = 1;
        tb[2] = 2;

        for(int i=3; i<=n ;i++) {
            tb[i] = tb[i-2] + tb[i-1];
        }

        return tb[n];
    }

    // top-down
    public int climbStairs(int n) {
        int[] m = new int[n+1];
        Arrays.fill(m, -1);

        return dfs(n, m);
    }

    public int dfs(int n, int[] m) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        if(m[n] != -1) {
            return m[n];
        }

        m[n] = dfs(n-1, m) + dfs(n-2, m);
        return m[n];
    }
}