def move(y, x, command, count, n):
    if command == 'U':
        if {abs(y - count) / n >= 1}:
            y = n+(y-count)
        else :
            y = y-count
    if command == 'D':
        if {abs(y + count) / n >= 1}:
            y = (y+count)%n
        else :
            y = y+count
    if command == 'L':
        if {abs(x - count) / n >= 1}:
            x = n+(x-count)
        else :
            y = y-count
    if command == 'R':
        if {abs(x + count) / n >= 1}:
            x = (x+count)%n
        else :
            x = x+count
    
#    array.pop(index): array배열에서 index번째 인덱스를 제거함
# array[:-number]: 뒤쪽에서 number개의 인데스를 가져온 배열
# array[-number:]: number 인덱스 전까지의 배열
    
def split_data(data):
    n = int(data.pop(0))
    n_squared = n ** 2
    
    array1 = data[:-n_squared]
    array2 = data[-n_squared:]
    
    return array1, array2

def solution():
    data = []
    
    while True:
        line = input().strip()
        if line == "":
            break
        data.extend(line.split())
    data = list(map(str, data))
    print(data)
    name, land = split_data(data)
    groom=[name[0]-1, name[1]-1]
    player=[name[2]-1, name[3]-1]
    print(groom)
    print(player)
    print(land)
    
solution()