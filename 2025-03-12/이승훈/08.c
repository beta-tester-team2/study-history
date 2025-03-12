#include <stdio.h>
int main() {
    // 차례대로 연속해서 빼면 무조건 0이 됨.
    int N, items[3] = { 14, 7, 1 }, cnt = 0;
    scanf("%d", &N);
    for (int i = 0; i < 3; i++) {
        cnt += N / items[i];
        N %= items[i];
    }
    printf("%d", cnt);
}