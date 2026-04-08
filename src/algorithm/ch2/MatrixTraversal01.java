package algorithm.ch2;

// 시간 복잡도: O(N×M)
public class MatrixTraversal01 {

    public static void rowMajorOrder(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        // 1. 행 반복문(바깥쪽)과 열 반복문(안쪽) 설정
        // 1-1. 행 인덱스 i는 0부터 행의 크기-1까지 반복
        for (int i = 0; i < rows; i++) {
            // 1-2. 열 인덱스 j는 0부터 열의 크기-1까지 반복
            for (int j = 0; j < cols; j++) {
                // 2. 현재 위치(i,j)의 원소에 접근
                // 2-1. arr[i][j] 형태로 각 원소에 접근
                System.out.print(arr[i][j] + " ");
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
        System.out.println("행 우선 순회 결과:");
        rowMajorOrder(matrix);
    }
}