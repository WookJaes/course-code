package algorithm.ch2;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        // 1. 외부 반복문: 정렬 과정을 몇 번 반복할지 결정
        // 배열의 크기만큼 반복, 한 번 반복할 때마다 하나의 숫자가 최종 위치로 이동
        for (int i = 0; i < n - 1; i++) {
            // 2. 내부 반복문: 실제 비교와 교환이 일어나는 과정
            // - 이웃한 두 숫자 비교
            // - 범위가 점점 줄어듦 (n-i-1): 이미 정렬된 요소는 제외
            for (int j = 0; j < n - i - 1; j++) {
                // 3. 인접한 두 요소 비교 및 교환
                // - 왼쪽 숫자가 오른쪽 숫자보다 크면 두 숫자의 위치를 바꿈
                if (arr[j] > arr[j + 1]) {
                    // 이웃한 두 수 자리 교환
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 2};

        System.out.println("정렬 전 배열:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("정렬 후 배열:");
        printArray(arr);
    }
}