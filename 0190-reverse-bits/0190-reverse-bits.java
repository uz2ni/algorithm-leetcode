class Solution {
    // 1byte = 8bit, int형 4byte = 32bit
    // 문제에서 32비트 라는건 int형으로 주어진 수니까 32bit인것. 특별히 조건을 준게 아니고 명시해준 것
    // 우리가 보기에는 10진수, 컴퓨터가 저장하기에는 2진수 bit 형태

    // 비트 순서를 반전한다 : 0<->1 전환이 아님. 이건 비트반전 NOT 연산. 자리의 위치를 뒤집는 의미임. 123->321 처럼.
    public int reverseBits(int n) {
        // 만약 10진수 반전이라면 43261596 -> 69516234
        // n의 2진수 순서 반전해야 함

        // 1. n을 32자리 이진수 문자열로 변환
        // String.format("%32s", Integer.toBinaryString(n)) : 32비트 오른쪽 자리부터 채워지고, 앞에 남은건 ' ' 빈값 처리됨
        // String.replace(' ', '0') : 빈 값은 0 처리
        String binary = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0'); 

        // 2. 뒤집기
        String reversedBinary = new StringBuilder(binary).reverse().toString();
        
        // 3. 10진수 변환
        // int형에 32bit를 담아야하는데 java의 int는 무조건 부호 비트 사용함.
        // 첫자리는 부호bit 이므로 31bit로 담으려면 overflow.
        // long으로 여유있게 담고 나중에 int로 변환 (형변환 시 앞비트 잘라내기만 해서 에러안난다(?))
        return (int) Long.parseLong(reversedBinary, 2);
    }
}