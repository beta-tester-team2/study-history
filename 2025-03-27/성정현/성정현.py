from collections import deque

numOfNode, numOfEdge, startNode, destination = map(int, input().split(" "))

graph = [[] for _ in range(numOfNode + 1)]
for _ in range(numOfEdge):
eFrom, eTo = map(int, input().split(" "))
graph[eFrom].append(eTo)
graph[eTo].append(eFrom)



for cantUse in range(1, numOfNode + 1):
#도착 도시가 공사중일 경우
if cantUse == destination or cantUse == startNode:
print(-1)
continue
visit = [False for _ in range(numOfNode + 1)]
print("cantUse", cantUse)

queue = deque([startNode])

result = -1
dist = 0
visit[startNode] = True
while queue:
dist += 1
print("dist", dist)
for _ in range(len(queue)):
now = queue.popleft()
print("now", now)
for to in graph[now]:
if to == destination:
result = dist
break
if not visit[to] and to != cantUse:
queue.append(to)
visit[to] = True

print(result)