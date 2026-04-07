package algorithm.ch2;

public class BiSearch {

    private static int binarySearch(int[] arr, int target) {
        // 1. 탐색 범위의 시작과 끝 설정
        // 1-1. 배열의 첫 번째 인덱스
        int left = 0;
        // 1-2. 배열의 마지막 인덱스
        int right = arr.length - 1;

        // 2. 탐색 범위가 유효한 경우 반복
        while (left <= right) {
            // 2-1. 중간 위치 계산
            int mid = (left + right) / 2;
            // 3. 중간 값과 target 비교 후 처리
            // 3-1. 중간 값이 target 이면 해당 인덱스 반환
            if (arr[mid] == target) {
                return mid;
            }
            // 3-2. 중간 값이 target 보다 크면 오른쪽 범위를 줄임
            else if (arr[mid] > target) {
                right = mid - 1;
            }
            // 3-3. 중간 값이 target 보다 작으면 왼쪽 범위를 줄임
            else {
                left = mid + 1;
            }
        }
        // 4. 탐색 완료 후 결과 처리
        // 4-1. 찾지 못한 경우 실패(-1) 반환
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // 정렬된 배열
        int target = 7;

        int result = binarySearch(arr, target);
        if (result != -1) {
            System.out.println("찾은 위치: " + result);
        } else {
            System.out.println("값을 찾지 못했습니다.");
        }
    }
}