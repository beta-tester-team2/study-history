def search(cityMap, x, y, mark, size):
    # print("x = ", x, "y = ", y)
    stack = []
    if x >= size or y >= size or x < 0 or y < 0:
        # print("skip1")
        return
    if cityMap[x][y] != 1:
        # print("skip2")
        return
    cityMap[x][y] = mark
    # print(cityMap)
    search(cityMap, x+1, y, mark, size)
    search(cityMap, x, y+1, mark, size)
    search(cityMap, x-1, y, mark, size)
    search(cityMap, x, y-1, mark, size)

    
def search2(cityMap, x, y, mark, size):
    # print("x = ", x, "y = ", y)
    stack = [(x, y)]
    while stack:
        # print(stack)
        top = stack.pop()
        x = top[0]
        y = top[1]
        if x >= size or y >= size or x < 0 or y < 0:
            # print("skip1")
            continue
        if cityMap[x][y] != 1:
            # print("skip2")
            continue
        cityMap[x][y] = mark
        stack.append((x + 1, y))
        stack.append((x, y + 1))
        stack.append((x - 1, y))
        stack.append((x, y - 1))
        # print(cityMap)
        # print(stack)
    
    return
    
size = int(input())

cityMap = [[int(i) for i in input().split(" ")] for j in range(size)]

mark = 2
for i in range(size):
    for j in range(size):
        search2(cityMap, i, j, mark, size)
        mark += 1
        
# print(cityMap)

resultList = [set(i) for i in cityMap]
result = set()
for i in resultList:
    result = result.union(i)
if 0 in result:
    result.remove(0)
# print(result)
print(len(result))