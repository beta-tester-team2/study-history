#DFS 사용하면 될 듯?
# 강한 연결 요소(SCC): 방향 그래프에서 서로 서로에게 도달 가능한 정점들의 최대 집합, 예제 1에서 [1,4].[2],[3]의 3개 의미
#											 SCC란, 그래프에서 어떤 두 정점(u, v)에 대해 u에서 v로 가는 경로와 v에서 u로 가는 경로가 모두 존재하는 정점 집합
#											 하나의 루프 라고 생각하면 됨, 꼭 이 문젤처럼 양뱡향으로 통하는게 아니어도 한방향 루프여도 scc라고 침
# scc 찾는 dfs 기법: 타잔, 코사라주 있는데 여기서 코사라주 써보겠음
# 그래프를 인접 리스트로 나타내면 됨, ex graph = {1: [2], 2: [3, 4], 3: [6], 4: [5], 5: [1], 6: [4]}

from collections import defaultdict #자동 딕셔너리 값 생성,    k 없이 v만 있어도 알아서 k 생성해서 딕셔너리(java에서 map) 만들어줌

def solution(n, connections):
    graph = defaultdict(list)  # 비어있는 정방향 그래프
    reverse_graph = defaultdict(list) # 비어있는 역방향 그래프

    for k, v in connections:
        graph[k].append(v) # defaultdict를 사용했기 때문에 1이라는 k가 없어도 알아서 생성하면서 v 값을 넣어준다
        reverse_graph[v].append(k)

    def dfs1(node): # 얘는 탐색 순서 기록용
        visited[node] = True
        for neighbor in graph[node]:
            if not visited[neighbor]:
                dfs1(neighbor)
        stack.append(node)  # 모든 인접 노드를 방문한 후 스택에 추가, 탐색 순서를 기록하기 위함
			 # dfs1 예제: SCC(루프)가 (1-2-3), (4-5-6) 이렇게 2개 있다면
       # 1 → 2 → 3 (완료 후 stack에 저장) 4 → 5 → 6 (완료 후 stack에 저장)
       # 탐색이 끝난 순서대로 스택에 들어가므로, 스택 상태: [3, 2, 1, 6, 5, 4]

    def dfs2(node): #얘는 덩어리 찾기용
        visited[node] = True
        scc.append(node)  # 탐색 즉시 scc기록, 애는 순서 상관x, 뭉친 덩어리(연합 , scc)을 찾는 용도
        for neighbor in reverse_graph[node]:  # 역그래프에서 갈 수 있는 모든 노드 방문
            if not visited[neighbor]:
                dfs2(neighbor)
				# dfs2 예제: SCC(루프)가 (1-2-3), (4-5-6) 이렇게 2개 있고, dfs1한 스택상태: [3, 2, 1, 6, 5, 4]
        # 스택에서 꺼낸 순서대로 DFS 수행, 4를 꺼내서 DFS 수행 → {4, 5, 6} (하나의 SCC), 1을 꺼내서 DFS 수행 → {1, 2, 3} (하나의 SCC)
        # 찾은 SCC: {4, 5, 6}, {1, 2, 3}
        # 탐색이 끝난 순서대로 스택에 들어가므로, 스택 상태: [3, 2, 1, 6, 5, 4]


    visited = [False] * (n + 1) # node가 0이 아니라 1부터 시작이라 n이 아니라 n+1
    stack = [] 
    stack = []

    #dfs1(탐색 순서 기록) 사용
    for i in range(1, n + 1):
        if not visited[i]:
            dfs1(i)

    visited = [False] * (n + 1) # dfs2 사용을 위해 다시 visited 리셋
    scc_list = []
    scc_count = 0

    while stack:
        node = stack.pop()  # 탐색이 늦게 완료된 순서대로 꺼냄
        if not visited[node]:  # # 방문하지 않았다면 새로운 SCC 탐색 시작
            scc = []
            dfs2(node)
            scc_list.append(scc) 
            scc_count += 1
    return scc_count
	
n, m = map(int, input().split()) 
connections = [tuple(map(int, input().split())) for i in range(m)]

print(solution(n, connections))