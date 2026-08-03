class Solution {
    public String convert(String s, int numRows) {
        System.out.println(s);

        if (numRows == 1) return s;

        // 1. 좌표에 문자 담기
        
        // 빈좌표 생성 (row: numRows, col: 1000(max))
        char[][] grid = new char[numRows][1000];

        // 좌표에 문자 담기
        // 첫 문자
        int i = 0;
        char c = s.charAt(i);
        int x = 0, y = 0;
        grid[x][y] = c;

        while(i + 1 < s.length()) {
            // 1) x축 numRows-1번 내려가면서 입력
            for(int z=0; z<numRows-1; z++) {
                if(i+1 < s.length()) {
                    System.out.println("i: " + i);
                    grid[++x][y] = s.charAt(++i);
                }
            }
            // 2) 사선 numRows-1번 이동 (x-1, y+1)
            for(int z=0; z<numRows-1; z++) {
                if(i+1 < s.length()) {
                    System.out.println("i: " + i);
                    grid[--x][++y] = s.charAt(++i);
                }
            }
        }

        // 좌표 순회하며 문자 합산
        StringBuilder sb = new StringBuilder();
        for(int k=0; k<grid.length; k++) {
            for(int t=0; t<grid[0].length; t++) {
                if(grid[k][t] != '\u0000') {
                    sb.append(grid[k][t]);
                }
            }
        }

        return sb.toString();
    }
}