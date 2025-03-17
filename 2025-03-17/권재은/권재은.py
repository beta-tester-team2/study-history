#연결된 집 뭉치 갯수 세기

def solution(home):
    n = len(home)
    visit = [[False] * n for i in range(n)]
    generator = 0  
    
    for i in range(n):
        for j in range(n):
            if home[i][j] == 1 and not visit[i][j]:
                visit[i][j] = True
                group(home, visit, i, j, n)
                generator += 1
    return generator

def group(home, visit, x, y, n):
    location = [(x, y)]
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    while location:
        x, y = location.pop() #.pop()는 가장 최근에 들어간 값을 꺼내고 제거하는 역할
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < n and not visit[nx][ny] and home[nx][ny] == 1:
                visit[nx][ny] = True
                location.append((nx, ny))

n = int(input())
home = [list(map(int, input().strip().split())) for i in range(n)]

print(solution(home))