
size,  numOfLine = map(int, input().split(" "))

lineList = []
gameMap = [[set() for _ in range(size)] for _ in range(size)]

for _ in range(numOfLine):
	y, x, direction = input().split(" ")
	x = int(x) - 1
	y = int(y) - 1
	lineList.append((y, x, direction))

for line in lineList:
	y, x, direction = line

	#수직
	if direction == 'D':
		for i in range(y, size, 1):
			gameMap[i][x].add('D')
			# if 'R' in gameMap[i][x]:
			# 	if 1 in gameMap[i][x]:
			# 		gameMap[i][x].add(2)
			# 	else:
			# 		gameMap[i][x].add(1)
			# if 'L' in gameMap[i][x]:
			# 	if 1 in gameMap[i][x]:
			# 		gameMap[i][x].add(2)
			# 	else:
			# 		gameMap[i][x].add(1)
				
	elif direction == 'U':
		for i in range(y, -1, -1):
			gameMap[i][x].add('U')
			# if 'R' in gameMap[i][x]:
			# 	if 1 in gameMap[i][x]:
			# 		gameMap[i][x].add(2)
			# 	else:
			# 		gameMap[i][x].add(1)
			# if 'L' in gameMap[i][x]:
			# 	if 1 in gameMap[i][x]:
			# 		gameMap[i][x].add(2)
			# 	else:
			# 		gameMap[i][x].add(1)
	#수평
	if direction == 'R':
		for i in range(x, size, 1):
			gameMap[y][i].add('R')
			# if 'U' in gameMap[y][i]:
			# 	if 1 in gameMap[y][i]:
			# 		gameMap[y][i].add(2)
			# 	else:
			# 		gameMap[y][i].add(1)
			# if 'D' in gameMap[y][i]:
			# 	if 1 in gameMap[y][i]:
			# 		gameMap[y][i].add(2)
			# 	else:
			# 		gameMap[y][i].add(1)
	elif direction == 'L':
		for i in range(x, -1, -1):
			gameMap[y][i].add('L')
			# if 'U' in gameMap[y][i]:
			# 	if 1 in gameMap[y][i]:
			# 		gameMap[y][i].add(2)
			# 	else:
			# 		gameMap[y][i].add(1)
			# if 'D' in gameMap[y][i]:
			# 	if 1 in gameMap[y][i]:
			# 		gameMap[y][i].add(2)
			# 	else:
			# 		gameMap[y][i].add(1)
				
	#map 출력
	# print("y = ", y, "x = ", x, "D = ", direction)
	# for gameMapSlice in gameMap:
	# 	print(gameMapSlice)
				

result = 0
for i in gameMap:
	for j in i:
		if 'U' in j:
			if 'R' in j:
				result += 1
			if 'L' in j:
				result += 1
		if 'D' in j:
			if 'R' in j:
				result += 1
			if 'L' in j:
				result += 1

print(result)