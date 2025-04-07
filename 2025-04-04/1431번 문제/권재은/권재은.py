def digit_sum(line): # 숫자만 골라서 합 구하기
    sum = 0
    for char in line:
        if char.isdigit():
            sum += int(char)
    return sum

n = int(input())
list = [input() for i in range(n)]

list.sort(key=lambda x: (len(x), digit_sum(x), x)) # 길이 작은순,숫자 합 작은 순, 사전 순

for line in list:
    print(line)