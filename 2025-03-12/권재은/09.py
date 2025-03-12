#lambda x: int(x): x를 정수로 변환하여 반환
#map함수: 리스트의 모든 요소에 특정 함수를 적용하는 역할, map 객체를 반환,
#                 직접 출력하면 메모리 주소가 보이므로, list()로 변환해서 봐야 함

def solution():
    n, k = map(int, input().split()) 
    land = [input().split() for i in range(n)]
    bomb = list(map(lambda x: int(x) - 1, input().split()) for i in range(k))
    destroy = [[0] * n for i in range(n)]
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    for y,x in bomb:
        if (land[y][x] != '@')and(land[y][x] != '#') :
            destroy[y][x] += 1
        elif land[y][x] == '@':
            destroy[y][x] += 2
            
        for dy, dx in directions:
            ny, nx = y+dy, x+dx
            if 0 <= ny < n and 0 <= nx < n:
                if (land[ny][nx] != '@')and(land[ny][nx] != '#') :
                    destroy[ny][nx] += 1
                elif land[ny][nx] == '@':
                    destroy[ny][nx] += 2
                        
    max_destroy= 0
    for j in range(n):
        for i in range(n):
            if destroy[j][i] > max_destroy:
                max_destroy=destroy[j][i]
        
    print(max_destroy)
    
solution()