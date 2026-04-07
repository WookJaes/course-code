package algorithm.ch2;

public class StableCountingSort {

    public static int[] stableCountingSort(int[] arr) {
        // 1. 카운팅 배열 생성
        // 원본 배열의 최댓값 찾기
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 원본 배열의 최댓값 크기만큼의 카운팅 배열 생성
        int[] counts = new int[max + 1];

        // 원본 배열을 순회하면서 각 숫자가 몇 번 등장했는지 카운팅 배열에 저장
        for (int num : arr) {
            counts[num]++;
        }

        // 2. 누적 합 배열 생성
        // 카운팅 배열과 같은 크기의 누적 합 배열 생성
        int[] cumulative = new int[max + 1];

        // 카운팅 배열을 순회하면서 각 위치까지의 누적 합 계산
        cumulative[0] = counts[0];
        for (int i = 1; i <= max; i++) {
            cumulative[i] = cumulative[i - 1] + counts[i];
        }

        // 3. 결과 배열 생성
        // 결과 배열을 원본 배열과 같은 크기로 생성
        int[] result = new int[arr.length];

        // 원본 배열을 뒤에서부터 순회
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            // 현재 숫자를 num이라 할 때, (cumulative[num] - 1)을 인덱스로 하여 결과 배열에 num 저장
            result[cumulative[num] - 1] = num;
            // cumulative[num]의 값을 1 감소
            cumulative[num]--;
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 1, 2};

        System.out.println("정렬 전 배열:");
        printArray(arr);

        int[] sortedArr = stableCountingSort(arr);

        System.out.println("정렬 후 배열:");
        printArray(sortedArr);
    }
}