# 과일별로 가격 대비 포만감 비율 계산
# 이 비율을 크기가 큰 순으로 정렬

def solution(n, budget, fruits):
    fruits.sort(key=lambda x: x[1] / x[0], reverse=True) # 가격 대비 포만감이 높은 순으로 정렬

    max_c = 0
    
    for p, c in fruits:
        if budget >= p: # 과일 통으로 구매
            max_c += c
            budget -= p
        else: #과일 조각 구매
            piece = budget / p  #살 수 있는 조각 갯수/비율? (소수로 표현됨)
            max_c += piece * c  # 그 비율만큼 포만감 추가
            budget = 0  #통으로 다 사고 나서 조각으로 살 수 있는 기회가 이 한번 말고 더 없음

        if budget == 0: 
            break

    print(int(max_c))


n, budget = map(int, input().split())
fruits = []
for i in range(n):  
    p, c = map(int, input().split())
    fruits.append((p, c)) 

solution(n, budget, fruits)