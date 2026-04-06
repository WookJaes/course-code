package algorithm.ch1;

public class SolutionBF {
    public static int[] findPairs(int[] numbers, int target) {
        // 1. 첫 번째 수 선택 단계
        for (int i = 0; i < numbers.length; i++) {

            // 1.1. 배열의 첫 번째 요소부터 순차적으로 선택
            // 1.2. 선택한 수를 첫 번째 수로 지정

            // 2. 두 번째 수 선택 및 검증 단계
            // 2.1. 첫 번째 수 다음 인덱스부터 배열 끝까지 순회
            for (int j = i + 1; j < numbers.length; j++) {
                // 2.2. 현재 선택된 두 수의 합이 target과 같은지 확인
                if (numbers[i] + numbers[j] == target) {
                    // 2.3. target과 같다면 두 수의 인덱스 반환
                    return new int[]{i, j};
                }
                // 2.4. target과 다르다면 다음 수 선택하여 2.2로 돌아가기
            }
        }
        // 3. 결과 반환 단계
        // 3.1. 조합을 찾은 경우 위에서 이미 반환
        // 3.2. 찾지 못한 경우 빈 배열 반환
        return new int[]{};
    }
    public static void main(String[] args) {
        // 테스트용 입력값 설정
        int[] numbers = {2, 11, 7, 15};
        int target = 9; // 예상 결과: [0, 2] (2 + 7 = 9)

        // findPairs 메서드 실행
        int[] result = findPairs(numbers, target);

        // 결과 출력 및 검증
        if (result.length == 0) {
            System.out.println("합이 " + target + "이 되는 두 수를 찾을 수 없습니다.");
        } else {
            System.out.printf("찾은 인덱스: [%d, %d]\n", result[0], result[1]);
            System.out.printf("해당 값: %d + %d = %d\n",
                numbers[result[0]], numbers[result[1]], target);
        }
    }
}