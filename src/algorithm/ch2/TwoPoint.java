package algorithm.ch2;

import java.util.Arrays;

public class TwoPoint {

    public static boolean findTwoSum(int[] arr, int target) {
        // 1. 포인터 초기화
        // 1-1. left 포인터는 배열의 첫 번째 인덱스로 설정
        int left = 0;
        // 1-2. right 포인터는 배열의 마지막 인덱스로 설정
        int right = arr.length - 1;

        // 2. 두 포인터가 교차하기 전까지 반복
        while (left < right) {
            // 2-1. 현재 두 포인터가 가리키는 값의 합 계산
            int sum = arr[left] + arr[right];

            // 2-2. 합과 목표값 비교
            // 3. 합과 목표값 비교 후 포인터 이동
            // 3-1. 합이 목표값과 같으면 true 반환 (쌍을 찾음)
            if (sum == target) {
                System.out.println("찾은 두 수: " + arr[left] + ", " + arr[right]);
                return true;
            }
            // 3-2. 합이 목표값보다 작으면 left 포인터를 오른쪽으로이동 (더 큰 값 필요)
            else if (sum < target) {
                left++;
            }
            // 3-3. 합이 목표값보다 크면 right 포인터를 왼쪽으로 이동 (더 작은 값 필요)
            else {
                right--;
            }
        }

        // 4. 탐색 완료 후 결과 처리
        // 4-1. 목표값을 만드는 쌍을 찾지 못한 경우 false 반환
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 8, 7, 3, 2};
        int target = 10;

        System.out.println("원본 배열: " + Arrays.toString(arr));
        System.out.println("목표 합: " + target);
        boolean result = findTwoSum(arr, target);
        System.out.println("합이 " + target + "이 되는 두 수가 " + (result ? "존재합니다." : "존재하지 않습니다."));
    }
}