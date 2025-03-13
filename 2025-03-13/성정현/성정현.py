size = int(input())

goormLocX, goormLocY = map(int, input().split(" "))
playerLocX, playerLocY = map(int, input().split(" "))

goormLocX -= 1
goormLocY -= 1
playerLocX -= 1
playerLocY -= 1

gameMap = [[i for i in input().split(" ")] for j in range(size)]
goormMap = [[0 for j in range(size)] for i in range(size)]
playerMap = [[0 for j in range(size)] for i in range(size)]

goormMap[goormLocX][goormLocY] = 1

gameCont = True
while gameCont:
    print(goormMap)
    print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ")
    count, command = list(gameMap[goormLocX][goormLocY])
    count = int(count)
    print(count)
    print(goormLocX)
    print(goormLocY)

    vector = {"U": (0, 1), "D": (0, -1), "R": (1, 0), "L": (-1, 0)}
    for i in range(count):
        goormLocX += vector.get(command)[0]
        goormLocY += vector.get(command)[1]

        if goormLocX >= size:
            goormLocX = 0
        elif goormLocY >= size:
            goormLocY = 0
        elif goormLocX < 0:
            goormLocX = size - 1
        elif goormLocY < 0:
            goormLocY = size - 1

        if goormMap[goormLocX][goormLocY] == 1:
            break
        goormMap[goormLocX][goormLocY] = 1
    print(goormMap)
    print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ")

playerMap[playerLocX][playerLocY] = 1

gameCont = True
while gameCont:
    count, command = list(gameMap[playerLocX][playerLocY])
    count = int(count)

    vector = {"U": (0, 1), "D": (0, -1), "R": (1, 0), "L": (-1, 0)}
    for i in range(count):
        playerLocX += vector.get(command)[0]
        playerLocY += vector.get(command)[1]

        if playerLocX >= size:
            playerLocX = 0
        elif playerLocY >= size:
            playerLocY = 0
        elif playerLocX < 0:
            playerLocX = size - 1
        elif playerLocY < 0:
            playerLocY = size - 1

        if playerMap[playerLocX][playerLocY] != 0:
            break
        playerMap[playerLocX][playerLocY] = 1
    print(playerMap)

goormResult = sum([sum(i) for i in goormMap])
playerResult = sum([sum(i) for i in playerMap])

if playerResult > goormResult:
    print("player " + str(playerResult))
else:
    print("goorm " + str(goormResult))

