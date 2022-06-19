num = set(range(1, 10001))

selfNum = set()

for i in range(1, 10001):
    for j in str(i):
        i += int(j)
    selfNum.add(i)
    
num = num - selfNum

for i in sorted(num):
    print(i)