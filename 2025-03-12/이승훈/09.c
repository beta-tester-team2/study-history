#include <stdio.h>
int main() {
    int dt[5][2] = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // board[0]: 누적피해량, board[1]: 입는피해량
    int board[2][201][201] = { 0 };
    int N, K, Y, X, max = -1;
    scanf("%d %d ", &N, &K);
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            // 입는 피해량 설정
            char ch;
            scanf("%c ", &ch);
            if (ch == '#') board[1][i][j] = 0;
            else if (ch == '0') board[1][i][j] = 1;
            else board[1][i][j] = 2;
        }
    }
    while (K--) {
        scanf("%d %d", &Y, &X);
        for (int i = 0; i < 5; i++) {
            // 좌표탐색 후 폭탄피해량 누적
            int cY = Y + dt[i][0];
            int cX = X + dt[i][1];
            if (cY < 0 || cY > N || cX < 0 || cX > N) continue;
            board[0][cY][cX] += board[1][cY][cX];
        }
    }
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            if (board[0][i][j] > max) max = board[0][i][j];
        }
    }
    printf("%d", max);
}