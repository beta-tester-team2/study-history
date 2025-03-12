userInput = input().split(" ")

width = int(userInput[0])
count = int(userInput[1])
vector = [(-1, 0), (0, -1),(0, 0), (1, 0), (0, 1)] 

inputMap = []
countMap = [[0 for i in range(width)] for j in range(width)]
for i in range(width):
    inputMap.append(input().split(" "))

for c in range(count):
    x, y = map(int, input().split(" "))
    x -= 1
    y -= 1
    for v in vector:
        newX = x+v[0]
        newY = y+v[1]
        if newX >= 0 and newY >= 0 and newX < width and newY < width:
            if inputMap[newX][newY] == "@":
                countMap[newX][newY] += 2
            if inputMap[newX][newY] == "#":
                countMap[newX][newY] += 0
            if inputMap[newX][newY] == "0":
                countMap[newX][newY] += 1

# print(countMap)                
                
resultArr = []
for i in countMap:
    for j in i:
        resultArr.append(j)
# print(resultArr)
result = max(resultArr)
print(result)