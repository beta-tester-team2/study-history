def DFS(gameMap, x, y, mapSize):
    print("search", x, y)
    vector = [(-1, 0), (0, -1), (1, 0), (0, 1)]
    markMap = [(x, y)]
    size = 0

    stack = [(x, y)]
    mark = gameMap[x][y]
    visited = set()

    while stack:
        curX, curY = stack.pop()
        print("cur =",curX,curY, mark, size)
        size += 1
        visited.add((curX, curY))

        for vec in vector:
            vecX, vecY = vec
            nxtX = curX + vecX
            nxtY = curY + vecY

            if nxtX >= mapSize or nxtX < 0:
                continue
            if nxtY >= mapSize or nxtY < 0:
                continue

            if gameMap[nxtX][nxtY] == mark and (nxtX, nxtY) not in visited:
                stack.append((nxtX, nxtY))
                markMap.append((nxtX, nxtY))
                print(stack)

    return size, markMap


def printMap(gameMap):
    for line in gameMap:
        for c in line:
            print(c, end='')
        print("")


def removeMap(gameMap, markMap):
    for cur in markMap:
        x, y = cur
        gameMap[x][y] = '.'


size, limit, numOfInput = map(int, input().split(" "))
inputMap = [[i for i in input()] for i in range(size)]

inputList = []

for i in range(numOfInput):
    x, y, mark = input().split()
    x = int(x) - 1
    y = int(y) - 1
    inputMap[x][y] = mark

printMap(inputMap)

for i in range(size):
    for j in range(size):
        if inputMap[i][j] == '.':
            continue
        markSize, markMap = DFS(inputMap, i, j, size)
        if markSize >= limit:
            removeMap(inputMap, markMap)

printMap(inputMap)