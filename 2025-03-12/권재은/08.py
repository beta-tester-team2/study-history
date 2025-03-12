def solution(pain):
    count=0
    for n in [14, 7, 1]:
        count += pain // n
        pain %= n
    return count

pain = int(input())
print(solution(pain))