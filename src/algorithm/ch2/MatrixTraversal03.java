package algorithm.ch2;

// 시간 복잡도: O(N×M)
public class MatrixTraversal03 {
    public static void zigzagOrder(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        // 1. 행 인덱스에 따른 순회 방향 결정
        for (int i = 0; i < rows; i++) {
            // 1-1. 행 인덱스(i)가 짝수인 경우: 왼쪽에서 오른쪽으로 순회
            if (i % 2 == 0) {
                // 2-1. 짝수 행: j를 0부터 열의 크기-1까지 증가
                for (int j = 0; j < cols; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            // 1-2. 행 인덱스(i)가 홀수인 경우: 오른쪽에서 왼쪽으로 순회
        else {
                // 2-2. 홀수 행: j를 열의 크기-1부터 0까지 감소
                for (int j = cols - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            // 3. 다음 행으로 이동하여 반복
            // 3-1. 현재 행의 순회가 끝나면 다음 행으로 이동
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("지그재그 순회 결과:");
        zigzagOrder(matrix);
    }
}