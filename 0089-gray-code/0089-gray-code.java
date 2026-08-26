class Solution {
    public List<Integer> grayCode(int n) {
        List<String> result = new ArrayList<>(List.of("0","1"));
        
        for(int i=2; i<=n; i++) {
            List<String> next = new ArrayList<>();
            
            // 정방향
            for(String s : result) {
                next.add("0" + s);
            }

            // 역방향
            List<String> reversed = new ArrayList<>(result);
            Collections.reverse(reversed);
            for(String s : reversed) {
                next.add("1" + s);
            }

            result = next;
        }

        List<Integer> answer = new ArrayList<>();
        for(String r : result) {
            answer.add(Integer.parseInt(r, 2));
        }

        return answer;
    }
}