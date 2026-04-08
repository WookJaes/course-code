package algorithm.ch2;

// 시간 복잡도: O(N×M)
public class MatrixTraversal02 {

    public static void columnMajorOrder(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        // 1. 열 반복문(바깥쪽)과 행 반복문(안쪽) 설정
        // 1-1. 열 인덱스 j는 0부터 열의 크기-1까지 반복
        for (int j = 0; j < cols; j++) {
            // 1-2. 행 인덱스 i는 0부터 행의 크기-1까지 반복
            for (int i = 0; i < rows; i++) {
                // 2. 현재 위치(i,j)의 원소에 접근
                // 2-1. arr[i][j] 형태로 각 원소에 접근
                // 2-2. 각 열을 위에서 아래로 순회
                System.out.print(arr[i][j] + " ");
            }
            // 3. 다음 열로 이동하여 반복
            // 3-1. 현재 열의 순회가 끝나면 다음 열로 이동
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("열 우선 순회 결과:");
        columnMajorOrder(matrix);
    }
}