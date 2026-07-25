class Solution {
    public int maxArea(int[] height) {
        // 투포인터 두고 max 면적 구하기 O(N)
        // 이동 : 투포인터 중 낮은 벽에서 이동한다. 넓이 벽 높이는 낮은 벽으로 정해지므로 포인터 당기면 넓이가 더 커질 수 없기 때문
        int max = 0;
        int left = 0;
        int right = height.length-1;
        
        while(left < right) {
            int area = (right-left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);
            
            if(height[left] < height[right]) left++;
            else right--;
        }

        return max;
    }
}