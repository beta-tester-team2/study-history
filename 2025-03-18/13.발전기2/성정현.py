def search(villageMap, recordMap, x, y, size, mark, standard):
    stack = [(x, y)]
    previousBuilding = villageMap[x][y]
    # print("x ", x)
    # print("y ", y)
    buildingCount = 0
    
    
    while stack:
        x, y = stack.pop()
        # print(recordMap[x][y])
        
        if x < 0 or y < 0 or x >= size or y >= size:
            continue
        if recordMap[x][y] != 0:
            continue
    
        if villageMap[x][y] == previousBuilding:
            recordMap[x][y] = mark
            buildingCount += 1
        else:
            continue
    
        stack.append((x + 1, y))
        stack.append((x, y + 1))
        stack.append((x - 1, y))
        stack.append((x, y - 1))

    if buildingCount >= standard:
        return buildingCount
    else:
        return 0



size, standard = map(int, input().split(" "))

villageMap = [[int(i) for i in input().split(" ")] for j in range(size)]
recordMap = [[0 for i in range(size)] for j in range(size)]
danzi = [0 for i in range(size * size)]
mark = 1

# print(villageMap)
# print(recordMap)


for i in range(size):
    for j in range(size):
        danzi[villageMap[i][j]] += search(villageMap, recordMap, i, j, size, mark, standard)
        mark += 1

print(danzi)
size = 0
result = -1
for i, iSize in enumerate(danzi):
    if iSize >= size:
        size = iSize
        result = i

print(result)

    