# 최단거리 탐색이므로 bfs 사용
import heapq # 우선순위 큐, queue 대신에 min heap 사용, 정수 막 넣어도 작은 정수부터 꺼내줌, 함수도 heappop 쓰면됨!
from collections import defaultdict # 얘가 인접리스트!

def bfs(graph, start, end, banned):
    if start == banned or end == banned:
        return -1  # 출발지 또는 도착지가 공사 중이면 이동 불가

    visited = set()
    heap = [(1, start)] # heapq 초기세팅, (방문한 도시 수, 현재 도시) 형태의 튜플
# k,v 형식에서 k인 방문한 도시 수가 적은 순으로 정렬, 그 다음 b가 작은 순으로 heapq가 알아서 탐색
# 이게 (1,1)이면 현재 도시 1개 거쳤고 1에서 시작했다는 뜻, 이후 인접 도시가 3, 5라면 (2,3), (2,5)이고 k가 2로 같을 때 도시 번호가 작은 (2,3)을 우선 탐색

    while heap:
        count, city = heapq.heappop(heap) # heappop: 가장 작은 값을 꺼내고 제거, 남은 heap은 자동 정렬
        if city == end:
            return count
        if city in visited: # visited는 집합이므로 if ~ in 구문이 맞음, if city == visited int == set 이므로 항상 false
            continue
        visited.add(city)

        for next_city in (graph[city]): # graph[city]: 현재 city와 연결된 도시들
            if next_city == banned or next_city in visited:
                continue
            heapq.heappush(heap, (count + 1, next_city)) # heap에 (count + 1, next_city)를 추가해준다는 뜻

    return -1

n, m, s, e = map(int, input().split())
graph = defaultdict(list) # 인접 리스트 방식으로 쓰이는 저장된 딕셔너리, 여기다 연결된 도시 1:[2,3], 2:[1,5], 3:[1,4] 형식으로 저장

for i in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

for banned in range(1, n + 1): #banned는 공사하는 도시 번호
    result = bfs(graph, s, e, banned)
    print(result)