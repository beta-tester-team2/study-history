#bfs, directions 사용

from collections import deque

directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def solution():
    n, k, q = map(int, input().split())
    board = [list(input().strip()) for i in range(n)]
    groom = [input().split() for i in range(q)]

    for gr in groom:
        y, x, alphabet = int(gr[0]) - 1, int(gr[1]) - 1, gr[2]
        board[y][x] = alphabet

        visited = [[False] * n for i in range(n)]
        for i in range(n):
            for j in range(n):
                if board[i][j] != '.' and not visited[i][j]:
                    group = bfs(board, visited, i, j, n)
                    if len(group) >= k:
                        for y, x in group:
                            board[y][x] = '.'

    for row in board:
        print("".join(row)) # 리스트 내부 요소를 한줄로 주루룩 붙여서 문자열로 만들려면 .join() 사용

def bfs(board, visited, y, x, n):
    queue = deque()
    queue.append((y, x))
    visited[y][x] = True
    group = [(y, x)]
    alphabet = board[y][x]
    
    while queue:
        y, x = queue.popleft()
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            if (0 <= ny < n) and (0 <= nx < n):
                if not (visited[ny][nx]) and (board[ny][nx] == alphabet):
                    visited[ny][nx] = True
                    queue.append((ny, nx))
                    group.append((ny, nx))

    return group

solution()