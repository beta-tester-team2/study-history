userInput = input()

pain = int(userInput)

count = 0
remainPain = pain

if pain >= 14:
    remainPain %= 14
    count += pain // 14
    
# print(pain)
# print(count)

if remainPain >= 7:
    pain %= 7
    count += pain // 7
    
# print(pain)
# print(count)

if remainPain >= 1:
    pain %= 1
    count += pain // 1

# print(pain)
# print(count)
    
print(count)