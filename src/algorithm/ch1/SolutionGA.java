package algorithm.ch1;

import java.util.Arrays;

class SolutionGA {

    public static int maxMeetings(int[][] meetings) {
        // 1. 정렬 단계
        // 1.1. 종료 시간을 기준으로 오름차순 정렬
        // 2차원 배열에서 각 행(int[])이 이미 하나의 객체
        // 2차원 배열에서 meetings[i]가 행
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        // 2. 회의 선택 및 카운트 단계
        // 2.1. 첫 번째 회의 선택 및 카운트 1 증가
        int count = 1;
        // 2.2. 첫 번째 회의의 종료 시간 저장
        int lastEndTime = meetings[0][1];

        // 2.3. 이전 선택한 회의의 종료 시간보다 시작 시간이 같거나 늦은 회의 중에서
        // 가장 일찍 끝나는 회의 선택하고 카운트 증가
        // 2.4. 더 이상 선택할 회의가 없을 때까지 2.3 반복
        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] >= lastEndTime) {
                count++;
                lastEndTime = meetings[i][1];
            }
        }

        // 3. 결과 반환 단계
        // 3.1. 회의 카운트 반환
        return count;
    }

    public static void main(String[] args) {
        int[][] meetings = {
            {1, 4},
            {3, 5},
            {0, 6},
            {5, 7},
            {3, 8},
            {5, 9},
            {6, 10},
            {8, 11}
        };

        // 최대 회의 개수 구하기
        int maxCount = maxMeetings(meetings);
        System.out.println("최대 진행 가능한 회의 수: " + maxCount);
    }
}