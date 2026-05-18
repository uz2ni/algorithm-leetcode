class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> output1 = new ArrayList<>(); // 정렬X
        List<String> output2 = new ArrayList<>(); // 정렬O

        for(int i=0; i<strs.length; i++) {
            
            char[] chArr = strs[i].toCharArray();
            Arrays.sort(chArr);
            String reStr = new String(chArr);

            // 정렬O에서 정렬된 키워드 찾음
            int idx = output2.indexOf(reStr);
            if(idx == -1) {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                output1.add(newList);
                output2.add(reStr);
            }else {
                List<String> list = output1.get(idx);
                list.add(strs[i]);
            }
        }
        
        return output1;
    }
}
