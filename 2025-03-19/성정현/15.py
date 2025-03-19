fruitNum, money = map(int, input().split(" "))
fruitList = []
for i in range(fruitNum):
    p, c = map(int, input().split(" "))
    performance = c / p
    fruitList.append((p, c, performance))

fruitList = sorted(fruitList, key=lambda x:x[2])

# print(fruitList)

sum = 0
while fruitList:
    # print("money", money)
    # print("sum", sum)
    selected = fruitList.pop()
    if money - selected[0] == 0:
        sum += selected[1]
        break
    elif money - selected[0] < 0:
        sum += selected[2] * money
        break
    else:
        money -= selected[0]
        sum += selected[1]
        
print(int(sum))