# 가장 단지가 많은 건물 번호 찾기
# 단지 갯수가 똑같으면 건물 번호가 더 큰 단지 선택
# java의 map 같은거 사용하면 될 듯 => 파이썬 dictionary
# 파이썬의 map은 완전 다른 개념, 리스트의 모든 요소에 함수를 적용할 때 씀

def solution(home, k):
	n = len(home)
	visit = [[False] * n for _ in range(n)]
	group_count = {} # 파이썬에서 {}는 딕셔너리로, java에서의 map과 같이 k,v를 갖는 형식 
	# java에서도 map 할 때 초기 크기 지정해줄 필요 x, 배열(array)만 크기 지정 필요 o, 리스트(arrayList)는 동적 배열이라 크기 지정 필요 x

	for i in range(n):
		for j in range(n):
			if not visit[i][j]:
				home_type = home[i][j]
				visit[i][j] = True  
				group_size = group(home, visit, i, j, n, home_type)
				
				if group_size >= k:
					group_count[home_type] = group_count.get(home_type, 0) + 1 
					# group_count.get(home_type, 0) + 1 에서 +1은 value 에만 적용됨
          # .get(home_type, 0)에서 0은 해당되는 value가 없을 때 value는 0으로 설정하라는 default의 뜻

	max_groups = 0
	generator = 0 

	for home_type, count in group_count.items(): #.items: 딕셔너리의 모든 k,v를 튜플 형태로 home_type, count에 반환
		if (count > max_groups) or (count == max_groups and home_type > generator):
			max_groups = count
			generator = home_type
	
	return generator

def group(home, visit, x, y, n, home_type):
	location = [(x, y)]
	group_size = 0 
	directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
	
	while location:
		x, y = location.pop()
		group_size += 1
		
		for dx, dy in directions:
			nx, ny = x + dx, y + dy 
			if (0 <= nx < n) and (0 <= ny < n) and not (visit[nx][ny]) and (home[nx][ny] == home_type):
				visit[nx][ny] = True
				location.append((nx, ny))
				
	return group_size 


n, k = map(int, input().split())
home = [list(map(int, input().split())) for i in range(n)]

print(solution(home, k))