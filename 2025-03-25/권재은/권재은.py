#BFS, queue, 그래프 탐색 사용
# node: 컴퓨터, edge: 통신 회선

def solution():
    
    n, m = map(int, input().split())  # n: 컴퓨터 수, m: 통신 회선 수
    graph = {}  # graph: 각 컴퓨터가 연결된 다른 컴퓨터 목록을 저장하는 딕셔너리

    for i in range(m):
        a, b = map(int, input().split())

        if a not in graph:  # a와 b를 양방향으로 연결, 그래프 구성
            graph[a] = []
        graph[a].append(b)

        if b not in graph:
            graph[b] = []
        graph[b].append(a)

    visit = set()  # set은 수학에서의 집합 자료형
    components = []  # 리스트 안에 나중에 딕셔너리 넣을 수 있음
    # 바로 딕셔너리 안 쓰는 이유는 components = [({1, 3, 5, 7}, 4), ({2, 4, 6}, 2),...] 이렇게 표현하기 위함

    def bfs(start):
        queue = [start]  # queue는 fifo(선입선출)인데 bfs에서 첫 node부터 넓게넓게 퍼져나가기 위해 사용

        node = set()
        edge = 0
        visit.add(start)

        while queue:
            current = queue.pop(0)  # 큐에서 맨 앞 요소를 꺼냄, current = 지금 탐색 중인 요소
            node.add(current)

            for neighbor in graph.get(current, []):
                edge += 1  # 양방향 간선이므로 매번 증가

                # 아직 방문하지 않았다면 큐에 추가
                if neighbor not in visit:
                    visit.add(neighbor)
                    queue.append(neighbor)

        # 간선 수를 절반으로 나눔
        edge //= 2  # 양방향 간선이라 2번씩 세서 다시 돌리려고 2로 나눔, 단방향으로만 탐색하면 양방향 통신선을 못 찾아서 꼭 이렇게 해야함

        return node, edge

    for i in range(1, n + 1):
        if i not in visit:
            node, edge = bfs(i)
            components.append((node, edge))

    def sort(component):
        node, edge = component
        density = edge / len(node)

        return (-density, len(node), min(node))  # 순서대로 밀도 높은 순, 컴퓨터 갯수 적은 순, 작은 컴퓨터 번호 순

    best_component = sorted(components, key=sort)[0]  # key=sort 라는게 정렬기준(key)를 내가 정한 sort로 하겠다는 뜻

    result = sorted(best_component[0])  # 그냥 sorted는 오름차순
    print(" ".join(map(str, result)))

solution()