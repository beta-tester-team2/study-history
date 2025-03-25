numOfNode, numOfEdge = map(int, input().split(" "))
graph = [[] for _ in range(numOfNode + 1)]
component = [0 for _ in range(numOfNode + 1)]
componentEdgeInfo = [0 for _ in range(numOfNode + 1)]
componentNodeInfo = [0 for _ in range(numOfNode + 1)]
density = [0 for _ in range(numOfNode + 1)]

visit = [0 for _ in range(numOfNode + 1)]

for _ in range(numOfEdge):
    eFrom, eTo = map(int, input().split(" "))
    graph[eFrom].append(eTo)
    graph[eTo].append(eFrom)

mark = 1

for i in range(1, numOfNode + 1):
    if component[i] != 0:
        continue

    stack = [i]

    while stack:
        # print("stack", stack)
        now = stack.pop()
        component[now] = mark
        # print("now", now)

        for to in graph[now]:
            if component[to] == 0:
                # print("to", to)
                component[to] = mark
                # for j in graph[to]:
                # 	component[j] = mark
                stack = stack + graph[to]

    mark += 1
# print('----------------')

# print(component)
# print(graph)

for i, val in enumerate(component):
    componentEdgeInfo[val] += len(graph[i])
    componentNodeInfo[val] += 1

biggestDensityComponent = 0
biggestDensity = 0
for i in range(1, numOfNode + 1):
    if componentNodeInfo[i] != 0:
        density[i] = componentEdgeInfo[i] / componentNodeInfo[i]
        if biggestDensity < density[i]:
            biggestDensity = density[i]
            biggestDensityComponent = i
        elif biggestDensity == density[i]:
            if componentNodeInfo[biggestDensityComponent] > componentNodeInfo[i]:
                biggestDensity = density[i]
                biggestDensityComponent = i
            elif componentNodeInfo[biggestDensityComponent] == componentNodeInfo[i]:
                if component.index(biggestDensityComponent) > component.index(i):
                    biggestDensity = density[i]
                    biggestDensityComponent = i

result = []
for i, val in enumerate(component):
    if val == biggestDensityComponent:
        print(i, end=" ")

