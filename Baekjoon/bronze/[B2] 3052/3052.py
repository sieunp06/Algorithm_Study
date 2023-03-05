list = []

for i in range (10):
    num = int(input())
    list.append(num % 42)

    for j in range (len(list) - 1):
        if list[j] == num%42:
            del list[len(list) - 1]

print(len(list))