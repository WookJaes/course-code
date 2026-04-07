package algorithm.ch2;

import java.util.Arrays;

// 연속 부분 수열 합
public class SubarraySum {

    public static int findExactSum(int[] arr, int target) {
        // 1. 포인터와 현재 합계, 결과값 초기화
        // 1-1. start 포인터는 배열의 첫 번째 인덱스로 설정
        int start = 0;
        // 1-2. end 포인터는 배열의 두 번째 인덱스로 설정
        int end = 1;
        // 1-3. 현재까지의 합을 첫 번째 원소로 초기화
        // - 초기 구간은 첫 번째 원소만을 포함
        // - start 포인터가 가리키는 원소부터 end-1까지의 합
        int currentSum = arr[0];
        // 1-4. 찾은 구간의 개수를 0으로 초기화
        // - target과 정확히 일치하는 구간을 찾을 때마다 증가
        int count = 0;

        // 2. 구간 탐색
        // 배열의 모든 구간을 확인할 때까지 반복
        while (start < arr.length) {
            // 2-1. 현재 구간의 합이 정확히 target과 같은 경우
            if (currentSum == target) {
                // target과 일치하는 구간을 찾았으므로 count 증가
                count++;
                // end가 배열 끝에 도달하지 않은 경우
                if (end < arr.length) {
                    // 구간을 확장하기 위해 end 위치의 원소를 더하고 end 증가
                    currentSum += arr[end++];
                }
                // end가 배열 끝에 도달한 경우
                else {
                    // 더 이상 구간을 확장할 수 없으므로 start를 이동
                    currentSum -= arr[start++];
                }
            }
            // 2-2. end가 배열 끝에 도달하지 않았고, 현재 합이 target 보다 작은 경우
            else if (end < arr.length && currentSum < target) {
                // 구간의 합을 늘리기 위해 end 위치의 원소를 더하고end 증가
                currentSum += arr[end++];
            }
            // 2-3. end가 배열 끝에 도달했거나, 현재 합이 target보다 큰 경우
            else {
                // 구간의 합을 줄이기 위해 start 위치의 원소를 빼고 start 증가
                currentSum -= arr[start++];
            }
        }
        // 3. 탐색 완료 후 결과 처리
        // 3-1. 찾은 모든 구간의 개수 반환
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2};
        int target = 3;

        System.out.println("원본 배열: " + Arrays.toString(arr));
        System.out.println("목표 합: " + target);

        int result = findExactSum(arr, target);
        System.out.println("합이 정확히 " + target + "인 연속된 구간의 개수: " + result);

        System.out.println("\n만족하는 구간들:");
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == target) {
                    System.out.println(
                        Arrays.toString(Arrays.copyOfRange(arr, i, j + 1)) + " (합: " + sum + ")");
                }
            }
        }
    }
}