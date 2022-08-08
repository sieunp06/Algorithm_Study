receipt = int(input())
num = int(input())
total = 0

for i in range (num):
    money, count = list(map(int, input().split())) 
    total += money * count

if receipt == total:
    print("Yes")
else:
    print("No")