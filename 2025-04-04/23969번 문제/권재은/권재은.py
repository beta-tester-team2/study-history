def solution(n, k, array):
    count = 0
    for last in range(n, 1, -1): # last는 정렬되지 않은 마지막 인덱스, n부터 -1씩해서 n=2까지 반복
        for i in range(last - 1):
            if array[i] > array[i + 1]:
                tmp = array[i]
                array[i] = array[i + 1]
                array[i+1] = tmp
                count += 1
                if count == k:
                    return array
    return -1

n, k = map(int, input().split())
array = list(map(int, input().split()))

result = solution(n, k, array)
if result == -1:
    print(-1)
else:
    print(*result) # 리스트를 공백 구분으로 출력