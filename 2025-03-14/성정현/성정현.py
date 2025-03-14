pain = int(input())
bandage, medicine = map(int, input().split())

numOfBandage = 0
result = []

for i in range(pain // medicine + 1):
    numOfMedicine = i
    remainPain = pain - numOfMedicine * medicine
    numOfBandage = remainPain // bandage
    remainPain %= bandage
    # print(remainPain)
    if remainPain != 0:
        continue
    result.append(numOfMedicine + numOfBandage)

try:
    print(min(result))
except:
    print(-1)
    