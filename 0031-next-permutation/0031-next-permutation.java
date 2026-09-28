class Solution {
    public void nextPermutation(int[] nums) {
        // 1. 뒷쪽부터 오름차순 안되는 값(i) 찾기
        int pivot = -1;
        for(int i=nums.length-1; i>0; i--) {
            if(nums[i] > nums[i-1]) {
                pivot = i-1;
                break;
            }
        }

        if(pivot == -1) { // 마지막 정렬된 값(내림차순)이면 전체 뒤집기 (오름차순 만듦)
            reverse(nums, pivot);
            return;
        }

        // 2. pivot 값, 뒷쪽에서 pivot 값보다 큰 가장 작은 값이랑 swap
        int min = nums.length-1;
        while(nums[min] <= nums[pivot]) {
            min--;
        }
        int temp = nums[min];
        nums[min] = nums[pivot];
        nums[pivot] = temp;

        // 3. pivot 이후 값들 뒤집기
        reverse(nums, pivot);
    }

    public void reverse(int[] nums, int pivot) {
        int left = pivot+1;
        int right = nums.length-1;
        while(left < right) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
    }
}